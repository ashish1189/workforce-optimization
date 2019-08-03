package com.spo.cleaners.optimization;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spo.cleaners.optimization.data.RequestModel;
import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.service.OptimizationService;

@RestController
@RequestMapping("/app")
public class OptimizationController {
	
	@Autowired
	private OptimizationService service;
	
	@RequestMapping(value = "/optimize", method = RequestMethod.PUT, consumes = {"application/json"},
			produces = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<OptimizationResponse> getOptimizedData (@RequestBody RequestModel request) {
		System.out.println("Controller");
		return service.getWorkForceOptimization(request);
	}
}
