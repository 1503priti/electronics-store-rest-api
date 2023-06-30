package com.electronic.store.checkout.system.service;

import java.util.List;

import com.electronic.store.checkout.system.dto.ProductRequest;
import com.electronic.store.checkout.system.dto.ProductResponse;
import com.electronic.store.checkout.system.model.Product;

public interface ProductService {
	List<Product> getAllProduct();

	Product getProductByProductId(long productId);

	Product createProduct(ProductRequest productRequest);

	Product updateProduct(ProductRequest productRequest, long productId );

	void deleteProduct(long product);

	Product addDiscountByProductId(long productId);

}
