package com.shopping.clothstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.clothstore.entities.Order;
import com.shopping.clothstore.responseEntities.OrderResponse;
import com.shopping.clothstore.servicesImpl.OrderServiceImpl;


@CrossOrigin(origins = "http://localhost:3000")
@RestController

//@RequestMapping("/")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/takeOrders/{customerId}")
	public ResponseEntity<OrderResponse> createOrder(@PathVariable Long customerId) {
		
			OrderResponse orderResponse = orderService.createOrder(customerId);
			return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getOrders/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

	
}