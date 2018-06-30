package com.br.sp.ordernow.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.sp.ordernow.dao.CostumerDAO;
import com.br.sp.ordernow.model.Costumer;
import com.br.sp.ordernow.service.CostumerService;

@Service
public class CostumerServiceImpl implements CostumerService, UserDetailsService {
	
	@Autowired
	private CostumerDAO costumerDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Costumer save(Costumer user) {
		if(user.getIdUser() != null) {
			Costumer costumer = this.findById(user.getIdUser());
			if(costumer != null) {
				costumer.setPwdUser(this.bCryptPasswordEncoder.encode(user.getPwdUser()));
			}
			return this.costumerDAO.save(costumer);
		} 
		user.setPwdUser(this.bCryptPasswordEncoder.encode(user.getPwdUser()));
		return this.costumerDAO.save(user);
	}

	@Override
	public Costumer findByLogin(String login) {
		return this.costumerDAO.findByLoginUser(login);
	}

	@Override
	public Costumer findById(Long idUser) {
		Optional<Costumer> user = this.costumerDAO.findById(idUser);
		return user.orElse(null);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Costumer costumer = this.findByLogin(username);
		
		if(costumer == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(costumer.getLoginUser(), costumer.getPwdUser(), new ArrayList<>());
	}

}
