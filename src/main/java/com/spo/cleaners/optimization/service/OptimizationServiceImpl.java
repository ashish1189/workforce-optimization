package com.spo.cleaners.optimization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;
import com.spo.cleaners.optimization.utilities.Optimizer;

@Service
public class OptimizationServiceImpl implements OptimizationService {

	@Override
	public List<OptimizationResponse> getWorkForceOptimization(RequestModel request) {
		// TODO Auto-generated method stub
		Optimizer optimize = new Optimizer();

		return optimize.startOptimization(request);
	}

}
