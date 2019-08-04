package com.spo.cleaners.optimization.exception;

import java.util.UUID;

public class APIInternalServerException extends APIException {
	
	private static final long serialVersionUID = 1L;
	
	public APIInternalServerException() {
		
	}
	
	public APIInternalServerException(String code, String title, String details) {
		this.id = UUID.randomUUID().toString();
		this.code = code;
		this.title = title;
		this.details = details;
	}
}
