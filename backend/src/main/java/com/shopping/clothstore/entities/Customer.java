package com.shopping.clothstore.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(unique=true)
	private String email;
	
	private long phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", nullable=true)
	private Address address;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="login_id", nullable=true)
//	
//	private Login login;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> order;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItem;

	

//	public Login getLogin() {
//		return login;
//	}
//
//	public void setLogin(Login login) {
//		this.login = login;
//	}

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

	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Customer(String name, String email, long phoneNumber, Address address,  List<Order> order,
			List<CartItem> cartItem) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.order = order;
		this.cartItem = cartItem;
	}

	
	
	
	
	
	
	

}
