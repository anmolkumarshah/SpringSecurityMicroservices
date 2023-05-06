package com.anmol.spring_security.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anmol.spring_security.ProductService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
