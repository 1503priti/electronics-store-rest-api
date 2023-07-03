package com.electronic.store.checkout.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronic.store.checkout.system.model.Basket;
import com.electronic.store.checkout.system.model.Product;
import com.electronic.store.checkout.system.service.BasketService;

@RestController
@RequestMapping("/baskets")
public class BasketController {

	@Autowired
	private BasketService basketService;

	@PostMapping("/addPToBasket")
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ResponseEntity<String> addProductToBasket(@RequestParam Long id, @RequestParam int quantity) {
		basketService.addProductToBasket(id, quantity);
		return new ResponseEntity<String>("Add Product Done", HttpStatus.OK);

	}

	@GetMapping("/removePToBasket")
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ResponseEntity<String> removeProductFromBasket(@RequestParam Long id) {
		basketService.removeProductFromBasket(id);
		return new ResponseEntity<>("Remove Product Done",HttpStatus.OK);

	}

}
