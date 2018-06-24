package com.br.sp.ordernow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.sp.ordernow.model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
	
	@Query("select p from Product p where p.rest.idRest = :idRest")
	List<Product> findByIdRest(Long idRest);

}
