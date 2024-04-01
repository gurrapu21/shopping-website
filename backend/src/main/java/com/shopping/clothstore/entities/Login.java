package com.shopping.clothstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Login {

	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(unique=true)
	private String email;

	private String password;

//	@OneToOne(mappedBy = "login")
//	private Customer customer;
	
	
	private long customerId;
	
	
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(String email, String password, long customerId) {
		super();
		this.email = email;
		this.password = password;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Login [Id=" + Id + ", email=" + email + ", password=" + password + ", customerId=" + customerId + "]";
	}

	

}
