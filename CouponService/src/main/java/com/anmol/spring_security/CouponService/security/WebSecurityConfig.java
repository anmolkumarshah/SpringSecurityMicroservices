package com.anmol.spring_security.CouponService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET,"/coupon/**").hasAnyRole("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/coupon").hasRole("ADMIN")
		.anyRequest().permitAll().and()
//		.requestMatchers(HttpMethod.GET,"/h2-console/**").hasAnyRole("ADMIN","USER").and()
		.csrf().disable();
		return http.build();
	}
	
}
