package com.electronic.store.checkout.system.service;

import static org.springframework.beans.BeanUtils.copyProperties;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.store.checkout.system.dto.ProductResponse;
import com.electronic.store.checkout.system.exception.ProductServiceCustomException;
import com.electronic.store.checkout.system.exception.ResourceNotFoundException;
import com.electronic.store.checkout.system.model.Product;
import com.electronic.store.checkout.system.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProduct() {

		return repository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public ProductResponse getProductByProductId(long productId) {
		Product product = repository.findById(productId)
				                         .orElseThrow(()->
				                         new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));
		                            
        ProductResponse productResponse
        = new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
        
        
		/*
		 * if (productDb.isPresent()) { return productDb.get(); } else { throw new
		 * ResourceNotFoundException("Product record not found with productId : " +
		 * productId); }
		 */
	}

	@Override
	public Product createProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb = repository.findById(product.getProductId());
		if(productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setProductId(product.getProductId());
		//	productUpdate.setProductName(product.getProductName());
			productUpdate.setProductDescription(product.getProductDescription());
			productUpdate.setPrice(product.getPrice());
			repository.save(productUpdate);
			return productUpdate;
			
		}
		else {
			throw new ResourceNotFoundException("Product record not found with productId"+product.getProductId());
		}
	}

	@Override
	public void deleteProduct(long productId) {
    Optional<Product> productDb = this.repository.findById(productId);
		
		if(productDb.isPresent()) {
			this.repository.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Product Record not found with id : " + productId);
		}

	}

	@Override
	public Product addDiscountByProductId(long productId) {
		return null;
	}
	

}
