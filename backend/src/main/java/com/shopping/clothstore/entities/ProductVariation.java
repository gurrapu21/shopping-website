package com.shopping.clothstore.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class ProductVariation {

	public ProductVariation() {
		// TODO Auto-generated constructor stub
	}
	
	

	


	public ProductVariation(String color, String size, ProductQuantity productQuantity) {
		super();
		this.color = color;
		this.size = size;
		this.productQuantity = productQuantity;
	}






	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private String color;
	
	private String size;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique  = false)
	private ProductQuantity productQuantity;
	
	


	
	public ProductQuantity getProductQuantity() {
		return productQuantity;
	}



	public void setProductQuantity(ProductQuantity productQuantity) {
		this.productQuantity = productQuantity;
	}



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	
}
