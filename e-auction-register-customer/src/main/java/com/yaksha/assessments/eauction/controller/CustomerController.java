package com.yaksha.assessments.eauction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.eauction.entity.CustomerEntity;
import com.yaksha.assessments.eauction.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerEntity customerEntity, BindingResult result) {

		customerRepository.save(customerEntity);
		return ResponseEntity.ok(customerEntity);
	}

}
