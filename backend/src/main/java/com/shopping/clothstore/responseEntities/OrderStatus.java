package com.shopping.clothstore.responseEntities;

import com.shopping.clothstore.entities.CartItem;

public class OrderStatus {

	public OrderStatus() {
		// TODO Auto-generated constructor stub
	}
	
	private CartItem cartItem;
	
	private String status;

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderStatus(CartItem cartItem, String status) {
		super();
		this.cartItem = cartItem;
		this.status = status;
	}
	
	
}
