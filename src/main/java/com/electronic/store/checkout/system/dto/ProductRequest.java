package com.electronic.store.checkout.system.dto;






import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductRequest {
	
	private String productName;
    private String productDescription;
    private Double price;
    private int quantity;
    private int discount;
    
   
    

}
