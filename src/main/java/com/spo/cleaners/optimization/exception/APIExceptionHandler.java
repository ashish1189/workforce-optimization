package com.spo.cleaners.optimization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {
	
	@ExceptionHandler(APIBadRequestException.class)
	public ResponseEntity<APIException> buildBadRequestResponse (APIBadRequestException e) {
		return new ResponseEntity<APIException>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(APIInternalServerException.class)
	public ResponseEntity<APIException> buildInternalServerResponse (APIInternalServerException e) {
		return new ResponseEntity<APIException>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
