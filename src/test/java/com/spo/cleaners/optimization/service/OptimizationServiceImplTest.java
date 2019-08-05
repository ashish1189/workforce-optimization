package com.spo.cleaners.optimization.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;

@RunWith(SpringJUnit4ClassRunner.class)
public class OptimizationServiceImplTest {

	@Test
	public final void testGetWorkForceOptimization() {
		RequestModel request = new RequestModel();
		
		int[] structure = new int[4];
		structure[0] = 35;
		structure[1] = 21;
		structure[2] = 17;
		structure[3] = 28;
		
		request.setBuilding(structure);
		request.setSrCapacity(10);
		request.setJrCapacity(6);

		List<OptimizationResponse> response = new ArrayList<OptimizationResponse>();

		response = (new OptimizationServiceImpl()).getWorkForceOptimization(request);
		
		assertThat(response).isNotNull();
		assertThat(4).isEqualTo(response.size());
	}

}
