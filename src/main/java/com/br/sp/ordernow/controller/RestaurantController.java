package com.br.sp.ordernow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.sp.ordernow.model.Restaurant;
import com.br.sp.ordernow.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;

	/**
	 * Method to persist a new restaurant
	 * @param @RequestBody Restaurant restaurant
	 * @return ResponseEntity<Restaurant>
	 */
	@PostMapping("/new")
	public ResponseEntity<Restaurant> saveNewRestaurant(@RequestBody Restaurant restaurant) {
		return Optional
		        .ofNullable( this.restaurantService.save(restaurant) )
		        .map( newRestaurant -> ResponseEntity.status(HttpStatus.CREATED).body(newRestaurant) ) 
		        .orElseGet( () -> ResponseEntity.noContent().build() ); 
	}
	
	/**
	 * Method to retrieve a specific restaurant
	 * @param @PathVariable(name="idRest") Long idRest
	 * @return ResponseEntity<Restaurant>
	 * @throws Exception
	 */
	@GetMapping("{idRest}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(name="idRest") Long idRest) throws Exception {
		return Optional
		        .ofNullable( this.restaurantService.findById(idRest) )
		        .map( restaurant -> ResponseEntity.ok().body(restaurant) ) 
		        .orElseGet( () -> ResponseEntity.notFound().build() ); 
	}
	
	//TODO: FIND RESTAURANT BY DISHE
}
