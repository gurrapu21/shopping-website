package com.shopping.clothstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.clothstore.entities.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {
	
	public Login getByEmail(String email);
}
