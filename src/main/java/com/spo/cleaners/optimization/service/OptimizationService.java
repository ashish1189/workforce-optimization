package com.spo.cleaners.optimization.service;

import java.util.List;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;

public interface OptimizationService {
	List<OptimizationResponse> getWorkForceOptimization(RequestModel request);
}
