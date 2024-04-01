package com.shopping.clothstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.clothstore.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	
	
}
