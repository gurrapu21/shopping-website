package com.shopping.clothstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class ProductQuantity {

	public ProductQuantity() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductQuantity(int quantity, int soldQuantity, int availableQuantity) {
		super();
		this.quantity = quantity;
		this.soldQuantity = soldQuantity;
		this.availableQuantity = availableQuantity;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private int quantity;
	
	private int soldQuantity;
	
	private int availableQuantity;
	
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}


	

}
