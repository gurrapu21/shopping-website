package com.shopping.clothstore.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.clothstore.entities.CartItem;
import com.shopping.clothstore.entities.Customer;
import com.shopping.clothstore.entities.Product;
import com.shopping.clothstore.entities.ProductCost;
import com.shopping.clothstore.entities.ProductQuantity;
import com.shopping.clothstore.entities.ProductVariation;
import com.shopping.clothstore.repos.CartRepo;
import com.shopping.clothstore.repos.CustomerRepo;
import com.shopping.clothstore.repos.ProductRepo;
import com.shopping.clothstore.requestEntities.AddCart;
import com.shopping.clothstore.responseEntities.CartAndAddress;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@PersistenceContext
	private  EntityManager entityManager;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Transactional
	public void createProduct() {
        Product product = new Product();
        product.setName("Checks Shirt");
        product.setType("Shirt");
        product.setProductCost(new ProductCost(700,10,630));
        ArrayList<ProductVariation> pv = new ArrayList();
        pv.add(new ProductVariation("green","42",new ProductQuantity(10, 0, 10)));
//        pv.add(new ProductVariation("red","42"));
        product.setProductVariation(pv);
        product.setInStock(true);

        entityManager.persist(product);
    } 
	
	public List<Product> getProuducts() {
		
		return productRepo.findAll();
	}
	
	
	
	public String addProductToCart(AddCart addCart) {
		Customer customer = customerRepo.getById(addCart.getCustomerId()); 
		Product product = productRepo.getById(addCart.getProductId());
		ProductVariation pv = product.getProductVariation().stream()
				.filter(i -> i.getId() == addCart.getProductVariationId())
				.findFirst()
		        .orElse(null);
		
		Integer quantity = addCart.getQuantity();
		
	    // Check if the product is already in the customer's cart
	    CartItem existingCartItem = customer.getCartItem().stream()
	        .filter(cartItem -> cartItem.getProduct().getId()==product.getId() && cartItem.getProductVariation().getId()==pv.getId())
	        .findFirst()
	        .orElse(null);

	    if (existingCartItem != null) {
	        // If the product is already in the cart, update the quantity
	        existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
	    } else {
	        // If the product is not in the cart, create a new CartItem
	        CartItem newCartItem = new CartItem(product, pv, quantity);
	        customer.getCartItem().add(newCartItem);
	    }

	    // Save the customer to persist the changes
	    customerRepo.save(customer);
	    
	    return "ok";
	}
	
	public CartAndAddress getCart(long customerId) {
		
		Customer customer = customerRepo.getById(customerId);
		
		
		return new CartAndAddress(customer.getCartItem(), customer.getAddress());
	}
	
	public String removeCartItem(long customerId, long cartItemId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer != null) {
            List<CartItem> cartItems = customer.getCartItem();
            cartItems.removeIf(item -> item.getId() == cartItemId);
            customer.setCartItem(cartItems);
            customerRepo.save(customer);
            return "removed";
        } else {
            // Handle the case where the customer is not found
        	return "cannot find customer";
        }
    }
}
