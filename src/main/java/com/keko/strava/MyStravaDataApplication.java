package com.keko.strava;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.keko.strava.model.Activity;
import com.keko.strava.repository.ActivityRepository;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class MyStravaDataApplication  extends WebSecurityConfigurerAdapter {
	@Autowired
	private ActivityRepository activityRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStravaDataApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/activities")
	public ResponseEntity<List<Activity>> activities(final @AuthenticationPrincipal Principal principal) {
		
		List<Activity> lastActivity = activityRepository.findFirstByOrderByStartDateDesc();
		
		int lastEpoch = 0;
		if (lastActivity.isEmpty()==false) {
			lastEpoch = (int) (lastActivity.get(0).getStartDate().getTime()/1000);
		}
		System.out.println(lastEpoch);
		final RestTemplate restTemplate = new RestTemplate();

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(getAccessToken(principal));
	    final HttpEntity<String> entity =
	        new HttpEntity<String>("parameters", headers);
	    ResponseEntity<List<Activity>> rateResponse =
	            restTemplate.exchange("https://www.strava.com/api/v3/athlete/activities?after="+lastEpoch,
	                        HttpMethod.GET, entity, new ParameterizedTypeReference<List<Activity>>() {
	                });
	    List<Activity> activities = rateResponse.getBody();
	    
	    activityRepository.saveAll(activities);
	    
	    return rateResponse;
		
	}
	
	@RequestMapping("/activities2")
	public ResponseEntity<String> activities2(final @AuthenticationPrincipal Principal principal) {
		
		final RestTemplate restTemplate = new RestTemplate();

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(getAccessToken(principal));
	    final HttpEntity<String> entity =
	        new HttpEntity<String>("parameters", headers);

	    return restTemplate.exchange("https://www.strava.com/api/v3/athlete/activities", HttpMethod.GET, entity, String.class);
		
	}
	
	
	private String getAccessToken(
		      final Principal principal) {

		    final OAuth2Authentication oauth2Auth = (OAuth2Authentication) principal;
		    final OAuth2AuthenticationDetails oauth2AuthDetails =
		        (OAuth2AuthenticationDetails) oauth2Auth.getDetails();

		    return oauth2AuthDetails.getTokenValue();
		  }

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
        .antMatchers("/", "/login**", "/webjars/**", "/error**", "/console/**").permitAll()
        .anyRequest().authenticated()
        .and().logout().logoutSuccessUrl("/").permitAll()
        .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		http.csrf().disable();
        http.headers().frameOptions().disable();
	  }
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Scheduled(fixedRate = 60000)
	public void importActivities() {
		System.out.println("Entrou");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Principal principal = (Principal) authentication.getPrincipal();
		System.out.println(principal.getName());
	}
	
	
}
