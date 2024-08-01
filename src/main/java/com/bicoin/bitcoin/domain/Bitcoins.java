package com.bicoin.bitcoin.domain;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"bpi",
	"disclaimer",
	"time"
})
//@Generated("jsonschema2pojo")
public class Bitcoins {

	@JsonProperty("bpi")
	private Bpi bpi;
	@JsonProperty("disclaimer")
	private String disclaimer;
	@JsonProperty("time")
	private Time time;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("bpi")
	public Bpi getBpi() {
	return bpi;
	}

	@JsonProperty("bpi")
	public void setBpi(Bpi bpi) {
	this.bpi = bpi;
	}

	@JsonProperty("disclaimer")
	public String getDisclaimer() {
	return disclaimer;
	}

	@JsonProperty("disclaimer")
	public void setDisclaimer(String disclaimer) {
	this.disclaimer = disclaimer;
	}

	@JsonProperty("time")
	public Time getTime() {
	return time;
	}

	@JsonProperty("time")
	public void setTime(Time time) {
	this.time = time;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}