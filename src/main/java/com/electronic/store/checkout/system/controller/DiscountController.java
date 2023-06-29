package com.electronic.store.checkout.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.electronic.store.checkout.system.dto.DiscountRequest;


import com.electronic.store.checkout.system.service.DiscountService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
	@Autowired
	private DiscountService discountService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addDiscount(@RequestBody DiscountRequest discountRequest){
		this.discountService.addDiscount(discountRequest);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/{id}")
	public HttpStatus deleteDiscount(@PathVariable long id){
		this.discountService.deleteDiscount(id);
		return HttpStatus.OK;
	}
	
}
