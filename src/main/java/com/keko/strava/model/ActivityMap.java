
package com.keko.strava.model;

import java.util.HashMap;

import javax.persistence.Entity;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "summary_polyline",
    "resource_state"
})
@Entity
public class ActivityMap {
	@Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("summary_polyline")
    private String summaryPolyline;
    @JsonProperty("resource_state")
    private Integer resourceState;
    
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("summary_polyline")
    public String getSummaryPolyline() {
        return summaryPolyline;
    }

    @JsonProperty("summary_polyline")
    public void setSummaryPolyline(String summaryPolyline) {
        this.summaryPolyline = summaryPolyline;
    }

    @JsonProperty("resource_state")
    public Integer getResourceState() {
        return resourceState;
    }

    @JsonProperty("resource_state")
    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

}
