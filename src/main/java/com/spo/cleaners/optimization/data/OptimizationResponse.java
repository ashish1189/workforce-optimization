package com.spo.cleaners.optimization.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "senior", "junior" })
public class OptimizationResponse {

	@JsonProperty("senior")
	private Integer senior;
	@JsonProperty("junior")
	private Integer junior;

	public OptimizationResponse() {
		
	}
	
	public OptimizationResponse(Integer senior, Integer junior) {
		this.senior = senior;
		this.junior = junior;
	}

	@JsonProperty("senior")
	public Integer getSenior() {
		return senior;
	}

	@JsonProperty("senior")
	public void setSenior(Integer senior) {
		this.senior = senior;
	}

	@JsonProperty("junior")
	public Integer getJunior() {
		return junior;
	}

	@JsonProperty("junior")
	public void setJunior(Integer junior) {
		this.junior = junior;
	}

}