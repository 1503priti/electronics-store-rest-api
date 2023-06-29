package com.electronic.store.checkout.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronic.store.checkout.system.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository <Discount, Long> {

}
