package com.shopping.clothstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.clothstore.entities.CartItem;
import com.shopping.clothstore.entities.Product;
import com.shopping.clothstore.requestEntities.AddCart;
import com.shopping.clothstore.responseEntities.CartAndAddress;
import com.shopping.clothstore.servicesImpl.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;
	

	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getProducts() {
		
//		productServiceImpl.createProduct();
		return new ResponseEntity(productServiceImpl.getProuducts(),HttpStatus.OK);

	}
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody AddCart addCart){
		
		return new ResponseEntity(productServiceImpl.addProductToCart(addCart),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCart")
	public ResponseEntity<CartAndAddress> getCart(@RequestParam long customerId){
		
		CartAndAddress cartitems = productServiceImpl.getCart(customerId);
		return new ResponseEntity(cartitems, HttpStatus.OK);
		
	}
	
	@GetMapping("/removeFromCart")
	public ResponseEntity<String> removeCartItem(@RequestParam long itemId, @RequestParam long customerId){
		
		
		return  new ResponseEntity(productServiceImpl.removeCartItem(customerId, itemId), HttpStatus.OK);
	}
	
	

}
