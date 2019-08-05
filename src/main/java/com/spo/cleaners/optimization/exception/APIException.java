package com.spo.cleaners.optimization.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties("stackTrace")
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected String code;
	protected String title;
	protected String details;

	public APIException() {
		
	}

	public APIException(String id, String code, String title, String details) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}	
}
