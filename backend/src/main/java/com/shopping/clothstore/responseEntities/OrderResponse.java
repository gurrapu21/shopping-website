package com.shopping.clothstore.responseEntities;

import java.util.List;
import java.util.Map;

import com.shopping.clothstore.entities.CartItem;

public class OrderResponse {

	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}
	



	List<OrderStatus> orderStatus;



	public List<OrderStatus> getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(List<OrderStatus> orderStatus) {
		this.orderStatus = orderStatus;
	}



	public OrderResponse(List<OrderStatus> orderStatus) {
		super();
		this.orderStatus = orderStatus;
	}

	
	
	
	
}
