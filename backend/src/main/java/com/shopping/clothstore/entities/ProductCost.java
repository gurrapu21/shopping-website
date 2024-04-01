package com.shopping.clothstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class ProductCost {

	public ProductCost() {
		// TODO Auto-generated constructor stub
	}

	public ProductCost(int mRP, int discount, int sellingPrice) {
		super();
		MRP = mRP;
		this.discount = discount;
		this.sellingPrice = sellingPrice;
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private int MRP;
	
	private int discount;
	
	private int sellingPrice;
	
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public int getMRP() {
		return MRP;
	}

	public void setMRP(int mRP) {
		MRP = mRP;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	
	
	
}
