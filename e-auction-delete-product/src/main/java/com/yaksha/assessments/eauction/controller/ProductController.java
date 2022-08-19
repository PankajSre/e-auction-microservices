package com.yaksha.assessments.eauction.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.eauction.entity.ProductEntity;
import com.yaksha.assessments.eauction.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		Optional<ProductEntity> productEntity = productRepository.findById(id);
		if (productEntity.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok("Product Deleted Successfully");
		} else {
			return ResponseEntity.ok("The Product id " + id + " does not exists");
		}

	}

}
