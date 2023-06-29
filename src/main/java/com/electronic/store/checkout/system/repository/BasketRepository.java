package com.electronic.store.checkout.system.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronic.store.checkout.system.model.Basket;

@Repository
public interface BasketRepository extends JpaRepository <Basket,Long> {
	
	
}
