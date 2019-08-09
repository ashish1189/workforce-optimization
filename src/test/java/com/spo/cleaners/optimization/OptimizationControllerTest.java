package com.spo.cleaners.optimization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spo.cleaners.optimization.data.OptimizationResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OptimizationControllerTest {

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc	mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public final void testGetOptimizedData() throws Exception {	
		String content = "{\r\n" + 
				"	\"rooms\": [\r\n" + 
				"		35,\r\n" + 
				"		21,\r\n" + 
				"		17,\r\n" + 
				"		28\r\n" + 
				"	],\r\n" + 
				"	\"senior\": 10,\r\n" + 
				"	\"junior\": 6\r\n" + 
				"}";
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/app/optimize")
				.accept(MediaType.APPLICATION_JSON)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		List<OptimizationResponse> optimize = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<OptimizationResponse>>() {});
		
		assertThat(optimize).isNotNull();
		assertThat(4).isEqualTo(optimize.size());
	}
}
