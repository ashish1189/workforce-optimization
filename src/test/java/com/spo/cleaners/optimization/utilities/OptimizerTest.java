package com.spo.cleaners.optimization.utilities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;

public class OptimizerTest {

	@Test
	public final void test1() {
		
		Optimizer optimize = new Optimizer();
		RequestModel request = new RequestModel();
		
		int[] building = {24, 28};
		request.setBuilding(building);
		request.setSrCapacity(11);
		request.setJrCapacity(6);
		
		List<OptimizationResponse> response = optimize.startOptimization(request);
		
		assertThat(2).isEqualTo(response.size());
		
		List<OptimizationResponse> expected = new ArrayList<>();
		
		OptimizationResponse set1 = new OptimizationResponse();
		set1.setStructure(24);
		set1.setSenior(2);
		set1.setJunior(1);

		OptimizationResponse set2 = new OptimizationResponse();
		set2.setStructure(28);
		set2.setSenior(2);
		set2.setJunior(1);
		
		expected.add(set1);
		expected.add(set2);
		
		assertThat(expected.get(0).getStructure()).isEqualTo(response.get(0).getStructure());
		assertThat(expected.get(0).getSenior()).isEqualTo(response.get(0).getSenior());
		assertThat(expected.get(0).getJunior()).isEqualTo(response.get(0).getJunior());
		
		assertThat(expected.get(1).getStructure()).isEqualTo(response.get(1).getStructure());
		assertThat(expected.get(1).getSenior()).isEqualTo(response.get(1).getSenior());
		assertThat(expected.get(1).getJunior()).isEqualTo(response.get(1).getJunior());
	}

	@Test
	public final void test2() {
		
		Optimizer optimize = new Optimizer();
		RequestModel request = new RequestModel();
		
		int[] building = {35, 21};
		request.setBuilding(building);
		request.setSrCapacity(10);
		request.setJrCapacity(6);
		
		List<OptimizationResponse> response = optimize.startOptimization(request);
		
		assertThat(2).isEqualTo(response.size());
		
		List<OptimizationResponse> expected = new ArrayList<>();
		
		OptimizationResponse set1 = new OptimizationResponse();
		set1.setStructure(35);
		set1.setSenior(3);
		set1.setJunior(1);

		OptimizationResponse set2 = new OptimizationResponse();
		set2.setStructure(21);
		set2.setSenior(1);
		set2.setJunior(2);
		
		expected.add(set1);
		expected.add(set2);
		
		assertThat(expected.get(0).getStructure()).isEqualTo(response.get(0).getStructure());
		assertThat(expected.get(0).getSenior()).isEqualTo(response.get(0).getSenior());
		assertThat(expected.get(0).getJunior()).isEqualTo(response.get(0).getJunior());
		
		assertThat(expected.get(1).getStructure()).isEqualTo(response.get(1).getStructure());
		assertThat(expected.get(1).getSenior()).isEqualTo(response.get(1).getSenior());
		assertThat(expected.get(1).getJunior()).isEqualTo(response.get(1).getJunior());
	}
	
	@Test
	public final void test3() {
		
		Optimizer optimize = new Optimizer();
		RequestModel request = new RequestModel();
		
		int[] building = {17, 28};
		request.setBuilding(building);
		request.setSrCapacity(10);
		request.setJrCapacity(6);
		
		List<OptimizationResponse> response = optimize.startOptimization(request);
		
		assertThat(2).isEqualTo(response.size());
		
		List<OptimizationResponse> expected = new ArrayList<>();
		
		OptimizationResponse set1 = new OptimizationResponse();
		set1.setStructure(17);
		set1.setSenior(2);
		set1.setJunior(0);

		OptimizationResponse set2 = new OptimizationResponse();
		set2.setStructure(28);
		set2.setSenior(1);
		set2.setJunior(3);
		
		expected.add(set1);
		expected.add(set2);
		
		assertThat(expected.get(0).getStructure()).isEqualTo(response.get(0).getStructure());
		assertThat(expected.get(0).getSenior()).isEqualTo(response.get(0).getSenior());
		assertThat(expected.get(0).getJunior()).isEqualTo(response.get(0).getJunior());
		
		assertThat(expected.get(1).getStructure()).isEqualTo(response.get(1).getStructure());
		assertThat(expected.get(1).getSenior()).isEqualTo(response.get(1).getSenior());
		assertThat(expected.get(1).getJunior()).isEqualTo(response.get(1).getJunior());
	}
	
	@Test
	public final void test4() {
		
		Optimizer optimize = new Optimizer();
		RequestModel request = new RequestModel();
		
		int[] building = {16};
		request.setBuilding(building);
		request.setSrCapacity(10);
		request.setJrCapacity(6);
		
		List<OptimizationResponse> response = optimize.startOptimization(request);
		
		assertThat(1).isEqualTo(response.size());
		
		List<OptimizationResponse> expected = new ArrayList<>();
		
		OptimizationResponse set1 = new OptimizationResponse();
		set1.setStructure(16);
		set1.setSenior(1);
		set1.setJunior(1);
		
		expected.add(set1);
		
		assertThat(expected.get(0).getStructure()).isEqualTo(response.get(0).getStructure());
		assertThat(expected.get(0).getSenior()).isEqualTo(response.get(0).getSenior());
		assertThat(expected.get(0).getJunior()).isEqualTo(response.get(0).getJunior());
	}
}
