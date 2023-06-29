package com.electronic.store.checkout.system.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private long productId;
    private String productName;
    private String productDescription;
    private long price;
    private long quantity;
}