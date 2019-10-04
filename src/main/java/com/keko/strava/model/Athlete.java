
package com.keko.strava.model;

import java.util.HashMap;
import java.util.Map;

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
    "resource_state"
})
@Entity
public class Athlete {
	@Id
    @JsonProperty("id")
    private Double id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    
    @JsonProperty("id")
    public Double getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Double id) {
        this.id = id;
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
