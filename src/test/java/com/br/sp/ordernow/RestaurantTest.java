package com.br.sp.ordernow;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderNowApplication.class)
@AutoConfigureMockMvc
public class RestaurantTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findRestaurantById() throws Exception {
		int restId = 3;
		this.mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/" + restId))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.nmRest", Is.is("Restaurant XXX")));
	}
	
	//TODO: TEST CREATE RESTAURANT

}
