package com.electronic.store.checkout.system.service;

import java.util.List;

import com.electronic.store.checkout.system.dto.ProductRequest;
import com.electronic.store.checkout.system.dto.ProductResponse;
import com.electronic.store.checkout.system.model.Product;

public interface ProductService {
	List<Product> getAllProduct();

	Product getProductByProductId(Long productId);

	Product createProduct(ProductRequest productRequest);

	Product updateProduct(ProductRequest productRequest, Long productId );

	void deleteProduct(Long product);

	Product addDiscountToProduct(Long productId, int discount);


}
