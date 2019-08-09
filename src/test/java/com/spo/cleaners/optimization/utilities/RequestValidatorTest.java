package com.spo.cleaners.optimization.utilities;

import org.junit.Test;

import com.spo.cleaners.optimization.data.RequestModel;
import com.spo.cleaners.optimization.exception.APIBadRequestException;

public class RequestValidatorTest {

	@Test(expected=APIBadRequestException.class)
	public final void testValidateRequest() {

		RequestValidator validate = new RequestValidator();
		RequestModel request = new RequestModel();

		request.setBuilding(null);
		request.setSrCapacity(0);
		request.setJrCapacity(0);
		
		validate.validateRequest(request);
	}
	
	@Test(expected=APIBadRequestException.class)
	public final void testValidateEmptyStructures() {

		RequestValidator validate = new RequestValidator();
		RequestModel request = new RequestModel();

		int[] structures = {};

		request.setBuilding(structures);
		request.setSrCapacity(10);
		request.setJrCapacity(6);
		
		validate.validateRequest(request);
	}

	@Test(expected=APIBadRequestException.class)
	public final void testValidateNoRooms() {

		RequestValidator validate = new RequestValidator();
		RequestModel request = new RequestModel();

		int[] structures = {35, 21, 17, 28, 0};

		request.setBuilding(structures);
		request.setSrCapacity(10);
		request.setJrCapacity(6);
		
		validate.validateRequest(request);
	}
	
	@Test(expected=APIBadRequestException.class)
	public final void testValidateWorkers() {

		RequestValidator validate = new RequestValidator();
		RequestModel request = new RequestModel();

		int[] structures = {35, 21, 17, 28};

		request.setBuilding(structures);
		request.setSrCapacity(0);
		request.setJrCapacity(6);
		
		validate.validateRequest(request);
	}
	
	@Test(expected=APIBadRequestException.class)
	public final void testValidateJrWorkers() {

		RequestValidator validate = new RequestValidator();
		RequestModel request = new RequestModel();

		int[] structures = {35, 21, 17, 28};

		request.setBuilding(structures);
		request.setSrCapacity(10);
		request.setJrCapacity(16);
		
		validate.validateRequest(request);
	}
}
