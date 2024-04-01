package com.shopping.clothstore.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	public Product(String name, String type, boolean inStock, ProductCost productCost, 
			List<ProductVariation> productVariation) {
		super();
		this.name = name;
		this.type = type;
		this.inStock = inStock;
		this.productCost = productCost;
		
		this.productVariation = productVariation;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private String name;
	
	private String type;
	
	private boolean inStock;
	
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    private ProductCost productCost;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductVariation> productVariation;
	

	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public ProductCost getProductCost() {
		return productCost;
	}

	public void setProductCost(ProductCost productCost) {
		this.productCost = productCost;
	}

	

	public List<ProductVariation> getProductVariation() {
		return productVariation;
	}

	public void setProductVariation(List<ProductVariation> productVariation) {
		this.productVariation = productVariation;
	}

	
	
	
}
