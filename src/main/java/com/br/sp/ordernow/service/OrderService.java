package com.br.sp.ordernow.service;

import java.util.List;

import com.br.sp.ordernow.model.Order;

public interface OrderService {

	Order save(String costumerLogin, Order order);
	List<Order> findAllByIdCostumer(Long idCostumer);
}
