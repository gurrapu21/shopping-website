package com.shopping.clothstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Address(String houseNumber, String lane, String city, String state, int pincode
			) {
		super();
		
		this.houseNumber = houseNumber;
		this.lane = lane;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id; 
	
	
	private String houseNumber;
	
	private String lane;
	
	private String city;
	
	private String  state;
	
	private int pincode;
	
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getlane() {
		return lane;
	}

	public void setlane(String lane) {
		this.lane = lane;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	

	
	
	
}
