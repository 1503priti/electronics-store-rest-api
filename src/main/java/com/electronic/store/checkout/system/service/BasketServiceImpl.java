package com.electronic.store.checkout.system.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.store.checkout.system.exception.ProductServiceCustomException;
import com.electronic.store.checkout.system.model.Basket;
import com.electronic.store.checkout.system.model.BasketItem;
import com.electronic.store.checkout.system.model.Product;
import com.electronic.store.checkout.system.repository.BasketItemRepository;
import com.electronic.store.checkout.system.repository.BasketRepository;

@Service
public class BasketServiceImpl implements BasketService {
	@Autowired
	private BasketRepository basketRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	BasketItemRepository basketItemRepository;

	@Override
	public Basket addProductToBasket(Long id, int quantity) {
		Basket basket = new Basket();
		BasketItem basketItem = new BasketItem();
		basketItem.setQuantity(quantity);
		basketItem.setProduct(productService.getProductByProductId(id));
		basket.getItems().add(basketItem);
		return basketRepository.save(basket);
	}

	@Override
	public Basket removeProductFromBasket(Long id) {

		Optional<Basket> basket = basketRepository.findById(id);
		if (basket.isPresent()) {
			Basket basketUpdate = basket.get();
			Set<BasketItem> items = basketUpdate.getItems();
			BasketItem BasketItem = null;
			for (BasketItem item : items) {
				if (item.getId() == id) {
					BasketItem = item;
				}
			}
			items.remove(BasketItem);
			basketItemRepository.delete(BasketItem);
			basketUpdate.setItems(items);
			return basketRepository.save(basketUpdate);
		} else {
			throw new ProductServiceCustomException("Product with given with Id: " + id + " not found:",
					"PRODUCT_NOT_FOUND");
		}
	}
}