package com.yaksha.assessments.eauction.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.eauction.entity.BidsEntity;
import com.yaksha.assessments.eauction.entity.CustomerEntity;
import com.yaksha.assessments.eauction.entity.ProductEntity;
import com.yaksha.assessments.eauction.repository.BidsRepository;
import com.yaksha.assessments.eauction.repository.CustomerRepository;
import com.yaksha.assessments.eauction.repository.ProductRepository;

@RestController
@RequestMapping("/api/bids")
public class BidsController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BidsRepository bidsRepository;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/place-bid")
	public ResponseEntity<?> placeBid(@Valid @RequestBody BidsEntity bidsEntity, BindingResult result) {

		Optional<CustomerEntity> customer = customerRepository.findById(bidsEntity.getCustomerId());
		Optional<ProductEntity> product = productRepository.findById(bidsEntity.getProductId());
		if (customer.isPresent()) {
			if (product.isPresent()) {
				bidsRepository.save(bidsEntity);
				return ResponseEntity.ok(bidsEntity);
			} else {
				return ResponseEntity.ok("Product with id " + bidsEntity.getProductId() + " does not exists");
			}
		} else {
			return ResponseEntity.ok("Customer with id " + bidsEntity.getCustomerId() + " does not exists");
		}

	}

}
