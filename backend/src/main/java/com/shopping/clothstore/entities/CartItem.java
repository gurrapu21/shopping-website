package com.shopping.clothstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CartItem {
	
	
    public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	
	@OneToOne
	private ProductVariation productVariation;
	
	
	
//    @ManyToOne
//    @JoinColumn(name="cart_id", nullable=false)
//    private Cart cart;

    public ProductVariation getProductVariation() {
		return productVariation;
	}

	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}

	private Integer quantity;

    public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CartItem(Product product,  Integer quantity) {
		super();
		
		this.product = product;
//		this.cart = cart;
		this.quantity = quantity;
	}

	public CartItem(Product product, ProductVariation productVariation, Integer quantity) {
		super();
		this.product = product;
		this.productVariation = productVariation;
		this.quantity = quantity;
	}
	
	

    
    
    // getters and setters
}
