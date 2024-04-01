package com.shopping.clothstore.requestEntities;

import com.shopping.clothstore.entities.Address;

public class Registration {

	public Registration() {

	}

	private String Name;

	private String Email;

	private long phoneNumber;

	private String password;

	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Registration(String name, String email, long phoneNumber, 
			String password) {
		super();
		Name = name;
		Email = email;
		this.phoneNumber = phoneNumber;
		
		this.password = password;
	}

	@Override
	public String toString() {
		return "Registration [Name=" + Name + ", Email=" + Email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}

}
