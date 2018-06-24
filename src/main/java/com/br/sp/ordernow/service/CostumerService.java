package com.br.sp.ordernow.service;

import com.br.sp.ordernow.model.Costumer;

public interface CostumerService {

	Costumer save(Costumer user);
	Costumer findByLogin(String login);
	Costumer findById(Long idUser);
}
