package com.br.sp.ordernow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.sp.ordernow.model.Order;
import com.br.sp.ordernow.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	/**
	 * Method to persist a new order
	 * @param Authentication authentication
	 * @param @RequestBody Order order
	 * @return ResponseEntity<Order>
	 */
	@PostMapping("/new")
	public ResponseEntity<Order> saveNewOrder(Authentication authentication, @RequestBody Order order) {
		try {
			return new ResponseEntity<Order>(this.orderService.save(authentication.getName(), order), HttpStatus.CREATED);			
		} catch (Exception e) {
			return new ResponseEntity<>(new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Method to retrieve all orders from a costumer
	 * @param @PathVariable(name="idCostumer") Long idCostumer
	 * @return ResponseEntity<List<Order>>
	 */
	@GetMapping("/{idCostumer}")
	public ResponseEntity<List<Order>> findAllByIdCostumer(@PathVariable(name="idCostumer") Long idCostumer) {
		return Optional
				.ofNullable( this.orderService.findAllByIdCostumer(idCostumer) )
				.map( status -> ResponseEntity.ok().body(status))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	//TODO: ACCEPT ORDER
	
	//TODO: SEND ORDER TO COSTUMER
	
	//TODO: COSTUMER RATES ORDER
	
}
