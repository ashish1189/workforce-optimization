package com.spo.cleaners.optimization.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RequestModel {

	@JsonProperty("rooms")
	private int[] building;
	@JsonProperty("senior")
	private int srCapacity;
	@JsonProperty("junior")
	private int jrCapacity;
	
	@JsonProperty("rooms")
	public int[] getBuilding() {
		return building;
	}
	
	@JsonProperty("rooms")
	public void setBuilding(int[] building) {
		this.building = building;
	}
	
	@JsonProperty("senior")
	public int getSrCapacity() {
		return srCapacity;
	}
	
	@JsonProperty("senior")
	public void setSrCapacity(int srCapacity) {
		this.srCapacity = srCapacity;
	}
	
	@JsonProperty("junior")
	public int getJrCapacity() {
		return jrCapacity;
	}
	
	@JsonProperty("junior")
	public void setJrCapacity(int jrCapacity) {
		this.jrCapacity = jrCapacity;
	}
}
