package com.keko.strava.repository;

import org.springframework.data.repository.CrudRepository;

import com.keko.strava.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long>{
	
}
