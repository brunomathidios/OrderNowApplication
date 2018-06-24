package com.br.sp.ordernow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.sp.ordernow.model.Product;
import com.br.sp.ordernow.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService prodService;

	/**
	 * Method to retrieve all products from a restaurant
	 * @param @PathVariable(name="idRest") Long idRest
	 * @return ResponseEntity<List<Product>>
	 */
	@GetMapping("{idRest}")
	public ResponseEntity<List<Product>> findAllByIdRest(@PathVariable(name="idRest") Long idRest) {
		return Optional
				.ofNullable( this.prodService.findByIdRest(idRest) )
				.map( product -> ResponseEntity.ok().body(product) )
				.orElseGet( () -> ResponseEntity.notFound().build() );
	}
}
