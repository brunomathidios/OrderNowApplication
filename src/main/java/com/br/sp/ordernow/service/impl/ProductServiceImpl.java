package com.br.sp.ordernow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sp.ordernow.dao.ProductDAO;
import com.br.sp.ordernow.model.Product;
import com.br.sp.ordernow.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO prodDAO;
	
	@Override
	public Product save(Product p) {
		return this.prodDAO.save(p);
	}

	@Override
	public List<Product> findByIdRest(Long IdRest) {
		List<Product> prodList = this.prodDAO.findByIdRest(IdRest);
		return (prodList != null && !prodList.isEmpty()) ? prodList : null;
	}

}
