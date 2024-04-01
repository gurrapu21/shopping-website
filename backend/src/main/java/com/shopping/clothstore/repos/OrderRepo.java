package com.shopping.clothstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.clothstore.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
	
}
