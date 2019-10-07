package com.keko.strava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.keko.strava.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long>{
	List<Activity> findFirstByOrderByStartDateDesc();
}
