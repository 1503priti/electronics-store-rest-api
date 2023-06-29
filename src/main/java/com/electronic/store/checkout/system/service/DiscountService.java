package com.electronic.store.checkout.system.service;

import java.util.List;

import com.electronic.store.checkout.system.dto.DiscountRequest;
import com.electronic.store.checkout.system.model.Discount;

public interface DiscountService {

	List<Discount> DiscountsList();

	Discount getDiscountById(long id);

	void addDiscount(DiscountRequest discountRequest);

	void deleteDiscount(long id);

}
