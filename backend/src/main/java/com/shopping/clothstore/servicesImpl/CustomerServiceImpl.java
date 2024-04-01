package com.shopping.clothstore.servicesImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.clothstore.entities.Address;
import com.shopping.clothstore.entities.CartItem;
import com.shopping.clothstore.entities.Customer;
import com.shopping.clothstore.entities.Login;
import com.shopping.clothstore.entities.Order;
import com.shopping.clothstore.repos.CustomerRepo;
import com.shopping.clothstore.repos.LoginRepo;
import com.shopping.clothstore.requestEntities.GetLogin;
import com.shopping.clothstore.requestEntities.Registration;
import com.shopping.clothstore.services.CustomerServices;

@Service
public class CustomerServiceImpl{
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	LoginRepo loginRepo;

	public String register(Registration reg) {
		
		
		Customer customer = new Customer();
		
		
		customer.setName(reg.getName());
		customer.setPhoneNumber(reg.getPhoneNumber());
		customer.setEmail(reg.getEmail());
		customer.setCartItem(new ArrayList<CartItem>());
		customer.setAddress(reg.getAddress());
		Login customerLogin = new Login(reg.getEmail(),reg.getPassword());
//		customer.setLogin(customerLogin);
		customer.setOrder(new ArrayList<Order>());
		
		try {
		    Customer savedEntity = customerRepo.save(customer);
		    loginRepo.save(new Login(reg.getEmail(),reg.getPassword(),savedEntity.getId()));
		    if (savedEntity != null) {
		        return ("Entity saved successfully");
		    } else {
		       return ("Entity was not saved");
		    }
		} catch (Exception e) {
		  return ("An error occurred while saving the entity: " + e.getMessage());
		}

	}
	
	public Customer updateCustomer(Long id, Registration updatedCustomer) {
        // Fetch the customer from the database using the id
        Customer customer = customerRepo.findById(id).get();
        Login loginCustomer = loginRepo.getByEmail(updatedCustomer.getEmail());
        loginCustomer.setEmail(updatedCustomer.getEmail());
        loginCustomer.setPassword(updatedCustomer.getPassword());
        Address address = updatedCustomer.getAddress();
        address.setId(customer.getId());
        
        // Update the customer details
        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
//        customer.setLogin(loginCustomer);
        customer.setAddress(address);

        // Save the updated customer back to the database
        return customerRepo.save(customer);
    }

	public Customer getCustomer(long id) {
		
		return customerRepo.getById(id);
	}
	
	public long checkLogin(GetLogin login) {
		
		Login loginDetials = loginRepo.getByEmail(login.getEmail());
		
		
		System.out.println(loginDetials);
		
		if(loginDetials == null) return -1;
		else if (loginDetials.getPassword().equals(login.getPassword())) return loginDetials.getCustomerId();
		else return -1;
		
	}
	
}
