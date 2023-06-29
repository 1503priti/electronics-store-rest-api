package com.electronic.store.checkout.system.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "discounts")
public class Discount {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer  discountInPercentage;
    private String discountDescription;
    private Integer  discountCount;

}
