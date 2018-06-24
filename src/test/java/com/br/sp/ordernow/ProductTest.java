package com.br.sp.ordernow;

import org.hamcrest.collection.IsCollectionWithSize;
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
public class ProductTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findProductByIdRest() throws Exception {
		int restId = 4;
		this.mockMvc.perform(MockMvcRequestBuilders.get("/products/" + restId))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)));
	}

}
