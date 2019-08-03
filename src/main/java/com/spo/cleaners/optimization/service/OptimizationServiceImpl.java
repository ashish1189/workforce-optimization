package com.spo.cleaners.optimization.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;

@Service
public class OptimizationServiceImpl implements OptimizationService {

	@Override
	public List<OptimizationResponse> getWorkForceOptimization(RequestModel request) {
		// TODO Auto-generated method stub
		System.out.println("service");
		List<OptimizationResponse> response = new ArrayList<OptimizationResponse>();
		
		OptimizationResponse set1 = new OptimizationResponse(3, 1);
		OptimizationResponse set2 = new OptimizationResponse(1, 2);
		OptimizationResponse set3 = new OptimizationResponse(2, 0);
		OptimizationResponse set4 = new OptimizationResponse(1, 3);
		
		response.add(set1);
		response.add(set2);
		response.add(set3);
		response.add(set4);
		
		System.out.println("Buildings: "+Arrays.toString(request.getBuilding()));
		System.out.println("Senior Capacity: "+request.getSrCapacity());
		System.out.println("Junior Capacity: "+request.getJrCapacity());
		
		return response;
	}

}
