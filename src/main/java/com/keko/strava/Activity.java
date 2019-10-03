package com.keko.strava;

import java.sql.Timestamp;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
	
	private String name;
	private String type;
	@JsonProperty("start_date_local")
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
    private Timestamp startDateLocal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getStartDateLocal() {
		return startDateLocal;
	}
	public void setStartDateLocal(Timestamp startDateLocal) {
		this.startDateLocal = startDateLocal;
	}
	
	
	
}
