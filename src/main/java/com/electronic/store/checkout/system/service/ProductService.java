package com.electronic.store.checkout.system.service;

import java.util.List;

import com.electronic.store.checkout.system.dto.ProductResponse;
import com.electronic.store.checkout.system.model.Product;

public interface ProductService {
	List<Product> getAllProduct();

	ProductResponse getProductByProductId(long productId);

	Product createProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(long product);

	Product addDiscountByProductId(long productId);

}
