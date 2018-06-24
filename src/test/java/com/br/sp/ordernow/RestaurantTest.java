package com.br.sp.ordernow;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.br.sp.ordernow.model.Product;
import com.br.sp.ordernow.model.Restaurant;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderNowApplication.class)
@AutoConfigureMockMvc
public class RestaurantTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void createNewRestaurant() throws Exception {
		Restaurant rest = new Restaurant();
		rest.setNmRest("Restaurant from Canada");
		rest.setIdDishe(new Long(2));
		
		List<Product> productList = new ArrayList<Product>();
		
		Product prod1 = new Product();
		prod1.setNmProduct("Product xyz");
		prod1.setPrice(10.99);
		productList.add(prod1);
		
		Product prod2 = new Product();
		prod2.setNmProduct("Product zto");
		prod2.setPrice(5.99);
		productList.add(prod2);
		
		rest.setProductList(productList);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/restaurants/new").content(new Gson().toJson(rest))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void findRestaurantById() throws Exception {
		int restId = 3;
		this.mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/" + restId))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.nmRest", Is.is("Restaurant from Canada")));
	}
	
	//TODO: TEST FIND RESTAURANT BY DISHE
	
}
