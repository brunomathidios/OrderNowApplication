package com.br.sp.ordernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.sp.ordernow.model.Restaurant;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Long>{

}