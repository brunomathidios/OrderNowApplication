package com.br.sp.ordernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.sp.ordernow.model.Costumer;

@Repository
public interface CostumerDAO extends JpaRepository<Costumer, Long> {

	Costumer findByLoginUser(String login);
}
