package com.shopping.clothstore.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {

	public Order() {
		// TODO Auto-generated constructor stub
	}
	

	public Order(Date date, int amount, String paymentMethod, int quantity, String status, Product product,
			 Address address) {
		super();
		this.date = date;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.quantity = quantity;
		this.status = status;
		this.product = product;
		
		this.address = address;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private Date date;
	
	private int amount;
	
	private String paymentMethod;
	
	private int quantity;
	
	private String status;
	
	@ManyToOne
	@JoinColumn
	private Product product;
	

	
	@ManyToOne
	private Address address;

	@ManyToOne
	private ProductVariation productVariation;
	
	
	
	 

	public ProductVariation getProductVariation() {
		return productVariation;
	}


	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}


	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
