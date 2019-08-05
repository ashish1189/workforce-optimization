package com.spo.cleaners.optimization.exception;

import java.util.UUID;

public class APIBadRequestException extends APIException {

	private static final long serialVersionUID = 1L;

	public APIBadRequestException() {
		
	}

	public APIBadRequestException(String code, String title, String details) {
		this.id = UUID.randomUUID().toString();
		this.code = code;
		this.title = title;
		this.details = details;
	}
	
}
