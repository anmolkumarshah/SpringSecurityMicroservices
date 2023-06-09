package com.anmol.spring_security.CouponService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anmol.spring_security.CouponService.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);
	
}
