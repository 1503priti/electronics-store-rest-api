package com.electronic.store.checkout.system.service;

import static org.springframework.beans.BeanUtils.copyProperties;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.electronic.store.checkout.system.dto.ProductRequest;
import com.electronic.store.checkout.system.dto.ProductResponse;
import com.electronic.store.checkout.system.exception.ProductServiceCustomException;
import com.electronic.store.checkout.system.exception.StoreGenericException;
import com.electronic.store.checkout.system.exception.StoreNotFoundException;
import com.electronic.store.checkout.system.model.Discount;
import com.electronic.store.checkout.system.model.Product;
import com.electronic.store.checkout.system.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProduct() {
		try {
			return repository.findAll().stream().collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new StoreGenericException("There was an error listing the products");
		}
	}
	/*
	 * @Override public ProductResponse getProductByProductId(long productId) {
	 * Product product = repository.findById(productId).orElseThrow( () -> new
	 * ProductServiceCustomException("Product with given Id not found",
	 * "PRODUCT_NOT_FOUND"));
	 * 
	 * ProductResponse productResponse = new ProductResponse();
	 * copyProperties(product, productResponse); return productResponse;
	 */

	/*
	 * if (productDb.isPresent()) { return productDb.get(); } else { throw new
	 * ResourceNotFoundException("Product record not found with productId : " +
	 * productId); }
	 */
//	}
	@Override
	public Product getProductByProductId(long productId) {
		try {
			return repository.findById(productId).orElseThrow(() -> new ProductServiceCustomException(
					"Product with given with Id: " + productId + " not found:", "PRODUCT_NOT_FOUND"));
		} catch (ProductServiceCustomException s) {
			log.warn("The product with id [{}] was not found", productId);
			throw s;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new StoreGenericException("There was an error retrieving the product");

		}
	}

	@Override
	public Product createProduct(ProductRequest productRequest) {
		try {
			/*
			 * Product product = Product.builder()
			 * 
			 * .productDescription(productRequest.getProductDescription())
			 * .productName(productRequest.getProductName())
			 * .price(productRequest.getPrice()) .quantity(productRequest.getQuantity())
			 * .build();
			 * 
			 */
			Product productDb = new Product();
			productDb.setProductDescription(productRequest.getProductDescription());
			productDb.setProductName(productRequest.getProductName());
			productDb.setPrice(productRequest.getPrice());
			productDb.setQuantity(productRequest.getQuantity());
			Discount discount = new Discount();
			discount.setDiscount(0);
			productDb.setDiscount(discount);
			repository.save(productDb);
			return productDb;
		  
	}
		catch(DataIntegrityViolationException de) {
			log.error("The name [{}] already exists in our records");
			throw new ProductServiceCustomException("Product name:"+productRequest.getProductName()+ "already registered","PRODUCT_NAME_REGISTERED");
		}
		catch (Exception e){
            log.error(e.getMessage());
            throw new StoreGenericException("There was an error saving the product");
        }
		
	}
	@Override
	public Product updateProduct(ProductRequest productRequest, long productId) {
		Optional<Product> productDb = repository.findById(productId);
		if (productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setProductName(productRequest.getProductName());
			productUpdate.setProductDescription(productRequest.getProductDescription());
			productUpdate.setPrice(productRequest.getPrice());
			productUpdate.setQuantity(productRequest.getQuantity());
			repository.save(productUpdate);
			return productUpdate;

		} else {
			throw new ProductServiceCustomException("Product with given with Id: " + productId + " not found:",
					"PRODUCT_NOT_FOUND");
		}
	}

	@Override
	public void deleteProduct(long productId) {
		
		  Optional<Product> productDb = this.repository.findById(productId);
		  
		  if(productDb.isPresent()) { this.repository.delete(productDb.get());
		  }
		  else {
			  throw new ProductServiceCustomException("Product with given with Id: " + productId + " not found:",
						"PRODUCT_NOT_FOUND");
		  }
		  
		/*
		 * if (!repository.existsById(productId)) { log.info("Im in this loop {}",
		 * !repository.existsById(prodProductServiceCustomExceptionuctId)); throw new
		 * ProductServiceCustomException("Product with given with Id: " + productId +
		 * " not found:", "PRODUCT_NOT_FOUND"); }
		 */
		 
		// log.info("Deleting Product with id: {}", productId);
	//	repository.deleteById(productId);

	}

	
	@Override
	public Product addDiscountToProduct(long productId, int discount) {
	    Product productDb = repository.findById(productId).get();
	//	Optional<Product> productDb = repository.findById(productId);
	    if(productDb.getDiscount() == null) {
	    	Discount dis =  new Discount();
			dis.setDiscount(discount);
			productDb.setDiscount(dis);
	    }
	    else {
	    	productDb.getDiscount().setDiscount(discount);
	    }
		repository.save(productDb);
		return productDb;
	}

	
}
