package com.shopping.clothstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.clothstore.entities.ProductVariation;

public interface ProductVariationRepo extends JpaRepository<ProductVariation, Long> {

}
