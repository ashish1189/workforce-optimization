package com.spo.cleaners.optimization.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "structure", "senior", "junior" })
@JsonIgnoreProperties({"structure"})
public class OptimizationResponse {

	@JsonProperty("structure")
	private Integer structure;
	@JsonProperty("senior")
	private Integer senior;
	@JsonProperty("junior")
	private Integer junior;

	@JsonProperty("structure")
	public Integer getStructure() {
		return structure;
	}

	@JsonProperty("structure")
	public void setStructure(Integer structure) {
		this.structure = structure;
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