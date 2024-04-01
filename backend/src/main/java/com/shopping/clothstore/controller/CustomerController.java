package com.shopping.clothstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.clothstore.entities.Customer;
import com.shopping.clothstore.requestEntities.GetLogin;
import com.shopping.clothstore.requestEntities.Registration;
import com.shopping.clothstore.servicesImpl.CustomerServiceImpl;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerSerivceImpl;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> createCustomer(@RequestBody Registration registration){
		
		String msg = customerSerivceImpl.register(registration);
		
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Registration updatedCustomer) {
        return customerSerivceImpl.updateCustomer(id, updatedCustomer);
    }
	
	@GetMapping("/getCustomerDetails/{Id}")
	public Customer getCustomer(@PathVariable long Id) {
		
		return customerSerivceImpl.getCustomer(Id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Long> login(@RequestBody GetLogin loginDetails) {
		long id = customerSerivceImpl.checkLogin(loginDetails);
		return id > 0 ? 
		 new ResponseEntity(id, HttpStatus.ACCEPTED) :
		new ResponseEntity(id,HttpStatus.BAD_REQUEST);
	}
}
