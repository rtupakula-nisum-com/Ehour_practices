package com.nisum.timesheets.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.nisum.timesheets.rest.config.JWTAuthFilter;

@EnableWebSecurity
@EnableCaching
@SpringBootApplication
public class NisumRestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NisumRestSpringbootApplication.class, args);
	}
	
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JWTAuthFilter());
		registrationBean.addUrlPatterns("/api/*");

		return registrationBean;
	}
}
