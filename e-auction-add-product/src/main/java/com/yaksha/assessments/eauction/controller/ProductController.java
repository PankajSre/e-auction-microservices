package com.yaksha.assessments.eauction.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.eauction.entity.ProductEntity;
import com.yaksha.assessments.eauction.entity.SellerEntity;
import com.yaksha.assessments.eauction.repository.ProductRepository;
import com.yaksha.assessments.eauction.repository.SellerRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@PostMapping("/add")
	public ResponseEntity<?> registerProduct(@Valid @RequestBody ProductEntity productEntity, BindingResult result) {
		Optional<SellerEntity> findById = sellerRepository.findById(productEntity.getSellerId());
		if (findById.isPresent()) {
			productRepository.save(productEntity);
			return ResponseEntity.ok(productEntity);
		} else {
			return ResponseEntity.ok("The Seller id " + productEntity.getSellerId() + " does not exists");
		}

	}

}
