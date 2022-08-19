package com.yaksha.assessments.eauction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.eauction.entity.SellerEntity;
import com.yaksha.assessments.eauction.repository.SellerRepository;

@RestController
@RequestMapping("/api/seller/")
public class SellerController {

	@Autowired
	private SellerRepository repository;

	@PostMapping("/register")
	public ResponseEntity<?> registerSeller(@Valid @RequestBody SellerEntity sellerEntity, BindingResult result) {
		repository.save(sellerEntity);
		return ResponseEntity.ok(sellerEntity);
	}

}
