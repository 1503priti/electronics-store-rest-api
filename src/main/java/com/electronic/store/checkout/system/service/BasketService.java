package com.electronic.store.checkout.system.service;

import com.electronic.store.checkout.system.model.Basket;

public interface BasketService {
	Basket updateBasket(Basket basket);
    void addProduct (String productId, Integer count);
    void removeProductFromBasket(String productId, Integer count);
 
}
