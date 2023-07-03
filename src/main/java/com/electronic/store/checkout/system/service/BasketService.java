package com.electronic.store.checkout.system.service;

import com.electronic.store.checkout.system.model.Basket;

public interface BasketService {
	
    Basket addProductToBasket (Long id, int quantity);
    Basket removeProductFromBasket(Long id);
 
}
