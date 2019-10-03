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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
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
	public ResponseEntity<String> activities(final @AuthenticationPrincipal Principal principal) {
		System.out.println("passou");
		
		
		final RestTemplate restTemplate = new RestTemplate();

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(getAccessToken(principal));
	    final HttpEntity<String> entity =
	        new HttpEntity<String>("parameters", headers);

	    return restTemplate.exchange("https://www.strava.com/api/v3/activities", HttpMethod.GET, entity, String.class);
		
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
        .antMatchers("/", "/login**", "/webjars/**", "/error**").permitAll()
        .anyRequest().authenticated()
        .and().logout().logoutSuccessUrl("/").permitAll()
        .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	  }
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
}
