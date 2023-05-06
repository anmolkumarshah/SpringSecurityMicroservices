package com.anmol.spring_security.ProductService.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anmol.spring_security.ProductService.dto.CouponDTO;
import com.anmol.spring_security.ProductService.entity.Product;
import com.anmol.spring_security.ProductService.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired 
	RestTemplate restTemplate;
	
	@Value("${COUPON_SERVICE}")
	String COUPON_SERVICE;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product){
		Product savedProduct = repository.save(product);
		String coupon_code = savedProduct.getCoupon_code();
		
		double discount = 0;
		if(coupon_code != null) {
			
			ResponseEntity<CouponDTO> responseEntity = restTemplate.getForEntity(COUPON_SERVICE+coupon_code, CouponDTO.class);
			CouponDTO couponDTO = responseEntity.getBody();
			discount = couponDTO.getDiscount();
			
			logger.info("coupon selected -> {}",couponDTO);
		}
		
		
		double discountedPrice = savedProduct.getPrice() - ((discount/100) * savedProduct.getPrice());
		savedProduct.setPrice(discountedPrice);
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
