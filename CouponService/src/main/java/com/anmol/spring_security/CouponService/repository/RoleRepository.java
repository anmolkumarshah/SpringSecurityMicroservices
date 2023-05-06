package com.anmol.spring_security.CouponService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anmol.spring_security.CouponService.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<User, Long> {

	
}
