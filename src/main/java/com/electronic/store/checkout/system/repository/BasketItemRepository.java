package com.electronic.store.checkout.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.electronic.store.checkout.system.model.BasketItem;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {

}
