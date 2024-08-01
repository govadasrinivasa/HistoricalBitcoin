package com.bicoin.bitcoin.domain;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
//@Generated("jsonschema2pojo")
public class Bpi {

	@JsonIgnore
	private Map<String, Double> additionalProperties = new LinkedHashMap<String, Double>();
	
	@JsonAnyGetter
	public Map<String, Double> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Double value) {
	this.additionalProperties.put(name, value);
	}
	
	public void updateMap(Map<String, Double> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@JsonIgnore
	private String datesCompare;

	
}
