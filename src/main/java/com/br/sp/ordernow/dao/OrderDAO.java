package com.br.sp.ordernow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.sp.ordernow.model.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

	List<Order> findByIdCostumer(Long idCostumer);
}
