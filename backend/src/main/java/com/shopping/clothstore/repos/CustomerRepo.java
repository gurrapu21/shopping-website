package com.shopping.clothstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.clothstore.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{
	public Customer getByEmail(String email);
}
