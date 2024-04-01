package com.shopping.clothstore.requestEntities;

public class AddCart {

	public AddCart() {
		// TODO Auto-generated constructor stub
	}
	
	private long customerId;
	private long productId;
	private long productVariationId;
	private int quantity;
	
	
	public long getProductVariationId() {
		return productVariationId;
	}
	public void setProductVariationId(long productVariationId) {
		this.productVariationId = productVariationId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
