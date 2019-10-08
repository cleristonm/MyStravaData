package com.keko.strava.scheduling;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.keko.strava.model.Activity;
import com.keko.strava.repository.ActivityRepository;

@Component
public class Import {
	@Autowired
	private ActivityRepository activityRepository;

	@Scheduled(fixedRate = 300000)
	public void importActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		do {
		
			List<Activity> lastActivity = activityRepository.findFirstByOrderByStartDateDesc();
	
			int lastEpoch = 0;
			if (lastActivity.isEmpty() == false) {
				lastEpoch = (int) (lastActivity.get(0).getStartDate().getTime() / 1000);
			}
			
			final RestTemplate restTemplate = new RestTemplate();
	
			final HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth("ce80698258c77df2e06d6599d953f6c7311f6a7a");
			final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<List<Activity>> rateResponse = restTemplate.exchange(
					"https://www.strava.com/api/v3/athlete/activities?after=" + lastEpoch, HttpMethod.GET, entity,
					new ParameterizedTypeReference<List<Activity>>() {
					});
			activities = rateResponse.getBody();
	
			activityRepository.saveAll(activities);
		}while (activities.size()==30);
			
	}

	
}
