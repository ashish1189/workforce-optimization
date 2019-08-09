package com.spo.cleaners.optimization.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;
import com.spo.cleaners.optimization.exception.APIInternalServerException;
import com.spo.cleaners.optimization.utilities.Optimizer;
import com.spo.cleaners.optimization.utilities.RequestValidator;

@Service
public class OptimizationServiceImpl implements OptimizationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OptimizationServiceImpl.class);

	@Override
	public List<OptimizationResponse> getWorkForceOptimization(RequestModel request) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("Inside service");
			Optimizer optimize = new Optimizer();
			RequestValidator validate = new RequestValidator();

			validate.validateRequest(request);

			LOGGER.info("Returning response from service");
			return optimize.startOptimization(request);
		} catch (NullPointerException e) {
			// TODO: handle exception
			LOGGER.error("Error while processing request.", e);
			throw new APIInternalServerException("5001", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					"Internal error occured, cannot process request.");
		}
	}

}
