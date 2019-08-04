package com.spo.cleaners.optimization;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(OptimizationController.class);

	@RequestMapping(value = "/optimize", method = RequestMethod.PUT, consumes = { "application/json" }, produces = {
			"application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<OptimizationResponse> getOptimizedData(@RequestBody RequestModel request,
			@RequestHeader(value="Correlation-ID", required=false) String correlationId) {
		LOGGER.info("Invoking the service");
		return service.getWorkForceOptimization(request);
	}
}
