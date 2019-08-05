package com.spo.cleaners.optimization.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.spo.cleaners.optimization.data.RequestModel;
import com.spo.cleaners.optimization.exception.APIBadRequestException;

public class RequestValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestValidator.class);

	public void validateRequest(RequestModel request) {

		LOGGER.info("Validating the input request");
		if (null == request.getBuilding() && request.getSrCapacity() == 0 && request.getJrCapacity() == 0)
			throw new APIBadRequestException("4001", HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"No or empty request body provided.");

		validateStructures(request);
		validateRooms(request);
		validateWorkers(request);
		LOGGER.info("Successfully validated the request");
		
	}

	private void validateStructures(RequestModel request) {
		
		LOGGER.info("Validating structures.");

		if (null == request.getBuilding())
			throw new APIBadRequestException("4002", "NO_REAL_STRUCTURE", "At least one structre should be provided.");
		if (request.getBuilding().length == 0)
			throw new APIBadRequestException("4002", "NO_REAL_STRUCTURE", "At least one structre should be provided.");
	}

	private void validateRooms(RequestModel request) {

		LOGGER.info("Validating rooms for every structure.");
		int[] structures = request.getBuilding();

		for (int i = 0; i < structures.length; i++) {
			if (structures[i] <= 0)
				throw new APIBadRequestException("4003", "NO_REAL_ROOMS", "A structure should have at least one room.");
			else if (structures[i] > 100)
				throw new APIBadRequestException("4004", "TOO_MANY_ROOMS",
						"A structure should not have more than 100 rooms.");
		}
	}

	private void validateWorkers(RequestModel request) {

		LOGGER.info("Validating the junior & senior workers");

		if (request.getSrCapacity() <= 0 || request.getJrCapacity() <= 0)
			throw new APIBadRequestException("4005", "NO_REAL_WORKER",
					"Worker capacity should be a non zero positive entity.");
		else if (request.getJrCapacity() > request.getSrCapacity())
			throw new APIBadRequestException("4006", "NO_SENIOR_WORKER",
					"Junior cleaner's capacity cannot be greater than that of Senior cleaner.");
	}
}
