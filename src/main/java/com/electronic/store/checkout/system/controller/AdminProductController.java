package com.electronic.store.checkout.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.electronic.store.checkout.system.dto.ProductRequest;
import com.electronic.store.checkout.system.model.Product;
import com.electronic.store.checkout.system.service.ProductService;

@RestController
@RequestMapping("products")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Product>> getAllProduct() {
		return ResponseEntity.ok().body(productService.getAllProduct());
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
		return ResponseEntity.ok().body(this.productService.createProduct(productRequest));
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest productRequest,
			@PathVariable long productId) {

		return ResponseEntity.ok().body(this.productService.updateProduct(productRequest, productId));
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("{productId}")
	public HttpStatus deleteProduct(@PathVariable long productId) {
		this.productService.deleteProduct(productId);
		return HttpStatus.OK;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable long productId) {
		return ResponseEntity.ok().body(productService.getProductByProductId(productId));
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/addDiscounts")
	public ResponseEntity<Product> addDiscountToProduct(@RequestParam long productId
			,@RequestParam("discount") int discount)  {
		return ResponseEntity.ok().body(this.productService.addDiscountToProduct(productId,discount));
	}
	
}
