package com.br.sp.ordernow;

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

import com.br.sp.ordernow.model.Costumer;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderNowApplication.class)
@AutoConfigureMockMvc
public class CostumerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void createNewCostumer() throws Exception {
		Costumer costumer = new Costumer();
		costumer.setNmUser("Anonymous");
		costumer.setLoginUser("anonym");
		costumer.setPwdUser("123");
		this.mockMvc.perform(MockMvcRequestBuilders.post("/costumers/new").content(new Gson().toJson(costumer))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void login() throws Exception {
		String loginUser = "{\"loginUser\": \"brunom\",\n" + 
				"	\"pwdUser\": 123}";
		this.mockMvc.perform(MockMvcRequestBuilders.post("/login").content(loginUser))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.header().doesNotExist("Content-Type"))
			.andExpect(MockMvcResultMatchers.header().exists("Authorization"));
	}

}
