package com.keko.strava.scheduling;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

	//@Scheduled(fixedRate = 300000)
	public void importActivities() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Principal principal = (Principal) authentication.getPrincipal();
		List<Activity> lastActivity = activityRepository.findFirstByOrderByStartDateDesc();

		int lastEpoch = 0;
		if (lastActivity.isEmpty() == false) {
			lastEpoch = (int) (lastActivity.get(0).getStartDate().getTime() / 1000);
		}
		System.out.println(lastEpoch);
		final RestTemplate restTemplate = new RestTemplate();

		final HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(getAccessToken(principal));
		final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<List<Activity>> rateResponse = restTemplate.exchange(
				"https://www.strava.com/api/v3/athlete/activities?after=" + lastEpoch, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Activity>>() {
				});
		List<Activity> activities = rateResponse.getBody();

		activityRepository.saveAll(activities);
	}

	private String getAccessToken(final Principal principal) {

		final OAuth2Authentication oauth2Auth = (OAuth2Authentication) principal;
		final OAuth2AuthenticationDetails oauth2AuthDetails = (OAuth2AuthenticationDetails) oauth2Auth.getDetails();

		return oauth2AuthDetails.getTokenValue();
	}

}
