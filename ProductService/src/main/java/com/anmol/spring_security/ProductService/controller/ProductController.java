package com.anmol.spring_security.ProductService.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.spring_security.ProductService.entity.Product;
import com.anmol.spring_security.ProductService.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository repository;

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product){
		Product savedProduct = repository.save(product);
		return ResponseEntity.ok(savedProduct);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
		Optional<Product> optionalProduct = repository.findById(id);
		if(optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
