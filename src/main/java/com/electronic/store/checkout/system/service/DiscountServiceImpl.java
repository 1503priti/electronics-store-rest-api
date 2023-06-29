package com.electronic.store.checkout.system.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.store.checkout.system.dto.DiscountRequest;
import com.electronic.store.checkout.system.exception.ResourceNotFoundException;
import com.electronic.store.checkout.system.model.Discount;
import com.electronic.store.checkout.system.repository.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	private DiscountRepository repository;
	
	@Override
	public List<Discount> DiscountsList() {
		// TODO Auto-generated method stub
		 return repository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Discount getDiscountById(long id) {
		Optional<Discount> productDb = repository.findById(id);
		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ResourceNotFoundException("Product record not found with productId : " + id);
		}
	}

	@Override
	public void addDiscount(DiscountRequest discountRequest) {	
		Discount discount = Discount.builder()
				.discountInPercentage(discountRequest.getDiscountInPercentage())
				.discountCount(discountRequest.getDiscountCount())
				.discountDescription(discountRequest.getDiscountDescription())
				.build();
		      this.repository.save(discount);
				
		//return repository.save(discount);
	}

	@Override
	public void deleteDiscount(long productId) {
    Optional<Discount> productDb = this.repository.findById(productId);
		
		if(productDb.isPresent()) {
			this.repository.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Product Record not found with id : " + productId);
		}

		
	}

}
