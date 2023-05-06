package com.anmol.spring_security.CouponService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.spring_security.CouponService.entity.Coupon;
import com.anmol.spring_security.CouponService.repository.CouponRepository;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponRepository repository;

	Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping
	public Coupon save(@RequestBody Coupon coupon) {
		logger.info("received coupon -> {}", coupon);
		Coupon savedCoupon = repository.save(coupon);
		return savedCoupon;
	}
	
	@GetMapping("/{code}")
	public Coupon getCouponByCode(@PathVariable("code") String code) {
		Coupon receivedCoupon = repository.findByCode(code);
		logger.info("find by code coupon -> {}",receivedCoupon);
		return receivedCoupon;
	}

}
