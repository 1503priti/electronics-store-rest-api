package com.electronic.store.checkout.system.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "products")
public class Product {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long productId;
	    private String productName;
	    private String productDescription;
	    private Double price;
	    private int quantity;
	    
	    @OneToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER
	    		)
	    private Discount discount;
	    
	    
	
	    
	    
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "product_details_id") private ProductDetails
	 * productDetails;
	 */
	    
}


