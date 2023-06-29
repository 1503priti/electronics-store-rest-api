package com.electronic.store.checkout.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronic.store.checkout.system.model.Product;


@RestController
@RequestMapping("/baskets")
public class BasketController {

	//BasketService
	//CheckoutService
	
	//@Autowired
	//private BasketService basketService;
	
	/*
	 * @Autowired private CheckoutService checkoutService;
	 */
	@GetMapping("/checkout")
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ResponseEntity<List<Product>> getAllProduct(){
		return null;
	//	return ResponseEntity.ok().body(productService.getAllProduct());
	}
	
	// add products to Basket
	//Basket addProductInBasket()
	
}
