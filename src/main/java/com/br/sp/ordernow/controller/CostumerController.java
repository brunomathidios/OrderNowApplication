package com.br.sp.ordernow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.sp.ordernow.model.Costumer;
import com.br.sp.ordernow.service.CostumerService;

@RestController
@RequestMapping("/costumers")
public class CostumerController {

	@Autowired
	private CostumerService costumerService;

	/**
	 * Method to create a new costumer
	 * @param @RequestBody Costumer costumer
	 * @return ResponseEntity<Costumer>
	 */
	@PostMapping("/new")
	public ResponseEntity<Costumer> saveNewUser(@RequestBody Costumer costumer) {
		return Optional
				.ofNullable( this.costumerService.save(costumer) )
				.map( newCostumer -> ResponseEntity.status(HttpStatus.CREATED).body(newCostumer))
				.orElseGet( () -> ResponseEntity.noContent().build());
	}
}
