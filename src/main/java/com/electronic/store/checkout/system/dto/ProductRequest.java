package com.electronic.store.checkout.system.dto;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.electronic.store.checkout.system.model.ProductDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class ProductRequest {
	
	private String name;
    private String description;
    private long price;
    private long quantity;
    
    
    

}
