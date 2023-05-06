package com.anmol.spring_security.CouponService.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anmol.spring_security.CouponService.entity.User;
import com.anmol.spring_security.CouponService.repository.UserRepository;

@Service
public class MyCustomUserDetails implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User foundUser = repository.findByEmail(username);
		if(foundUser == null) {
			throw new UsernameNotFoundException("User not found with id "+username);
		}
		logger.info("found user -> {} and roles {}",foundUser,foundUser.getRoles());
		return new org.springframework.security.core.userdetails
				.User(foundUser.getEmail(), foundUser.getPassword(),foundUser.getRoles());

	}

}
