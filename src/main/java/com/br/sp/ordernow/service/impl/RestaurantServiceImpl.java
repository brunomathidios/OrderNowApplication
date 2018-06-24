package com.br.sp.ordernow.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sp.ordernow.dao.RestaurantDAO;
import com.br.sp.ordernow.model.Restaurant;
import com.br.sp.ordernow.service.RestaurantService;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantDAO restDAO;

	@Override
	public Restaurant save(Restaurant rest) {
		return this.restDAO.save(rest);
	}

	@Override
	public Restaurant findById(Long idRest) {
		Optional<Restaurant> restaurant = this.restDAO.findById(idRest);
		return restaurant.orElse(null);
	}

}
