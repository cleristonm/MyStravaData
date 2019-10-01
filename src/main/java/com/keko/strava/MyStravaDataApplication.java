package com.keko.strava;

import java.security.Principal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class MyStravaDataApplication  extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MyStravaDataApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/activities")
	public List<Activity> activities() {
		System.out.println("passou");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Activity>> rateResponse =
		        restTemplate.exchange("https://www.strava.com/api/v3/activities",
		                    HttpMethod.POST, null, new ParameterizedTypeReference<List<Activity>>() {
		                    });
		List<Activity> activities = rateResponse.getBody();
		return activities;
		
	}

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/login**", "/webjars/**", "/error**", "/activities**")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
	  }
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
}
