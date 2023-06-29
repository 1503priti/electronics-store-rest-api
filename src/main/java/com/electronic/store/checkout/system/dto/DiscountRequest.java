package com.electronic.store.checkout.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequest {
	private Integer discountInPercentage;
	private String discountDescription;
	private Integer discountCount;
	
	
}
