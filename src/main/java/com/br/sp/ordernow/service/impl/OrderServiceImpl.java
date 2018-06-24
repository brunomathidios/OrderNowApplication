package com.br.sp.ordernow.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sp.ordernow.dao.CostumerDAO;
import com.br.sp.ordernow.dao.OrderDAO;
import com.br.sp.ordernow.model.Costumer;
import com.br.sp.ordernow.model.Order;
import com.br.sp.ordernow.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private CostumerDAO costumerDAO;

	@Override
	public Order save(String costumerLogin, Order order) {
		order.setDtOrder(LocalDateTime.now());
		
		Costumer costumer = this.costumerDAO.findByLoginUser(costumerLogin);
		order.setIdCostumer(costumer.getIdUser());
		
		return this.orderDAO.save(order);
	}

	@Override
	public List<Order> findAllByIdCostumer(Long idCostumer) {
		return this.orderDAO.findByIdCostumer(idCostumer);
	}

}
