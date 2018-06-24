package com.br.sp.ordernow.service;

import com.br.sp.ordernow.model.Restaurant;

public interface RestaurantService {
	
	Restaurant save(Restaurant rest);
	Restaurant findById(Long idRest);

}
