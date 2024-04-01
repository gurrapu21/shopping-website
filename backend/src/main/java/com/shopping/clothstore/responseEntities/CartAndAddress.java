package com.shopping.clothstore.responseEntities;

import java.util.List;

import com.shopping.clothstore.entities.Address;
import com.shopping.clothstore.entities.CartItem;

public class CartAndAddress {

	private List<CartItem> items;
	
	private Address address;

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CartAndAddress(List<CartItem> items, Address address) {
		super();
		this.items = items;
		this.address = address;
	}
	
	

}
