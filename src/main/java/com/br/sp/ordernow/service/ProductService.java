package com.br.sp.ordernow.service;

import java.util.List;

import com.br.sp.ordernow.model.Product;

public interface ProductService {

	List<Product> findByIdRest(Long IdRest);
	Product save(Product p);
}
