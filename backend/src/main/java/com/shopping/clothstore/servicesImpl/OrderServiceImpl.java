package com.shopping.clothstore.servicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.clothstore.entities.CartItem;
import com.shopping.clothstore.entities.Customer;
import com.shopping.clothstore.entities.Order;
import com.shopping.clothstore.entities.ProductVariation;
import com.shopping.clothstore.repos.CustomerRepo;
import com.shopping.clothstore.repos.OrderRepo;
import com.shopping.clothstore.repos.ProductVariationRepo;
import com.shopping.clothstore.responseEntities.OrderResponse;
import com.shopping.clothstore.responseEntities.OrderStatus;

@Service
public class OrderServiceImpl {

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ProductVariationRepo productVariationRepository;

    @Autowired
    private OrderRepo orderRepository;
    
    @Autowired
    private ProductServiceImpl productService;

    public OrderResponse createOrder(Long customerId)  {
        Customer customer = customerRepository.findById(customerId).get();

        List<CartItem> refcartItems = new ArrayList<>(customer.getCartItem());
        
        List<OrderStatus> orderItemsStatus = new ArrayList<>();

        

        for (CartItem cartItem : refcartItems) {

            ProductVariation productVariation = cartItem.getProductVariation();
            
            if (productVariation.getProductQuantity().getAvailableQuantity() >= cartItem.getQuantity()) {
                productVariation.getProductQuantity().setAvailableQuantity(productVariation.getProductQuantity().getAvailableQuantity() - cartItem.getQuantity());
                productVariation.getProductQuantity().setSoldQuantity(productVariation.getProductQuantity().getSoldQuantity() + cartItem.getQuantity());

                productVariationRepository.save(productVariation);

                Order order = new Order();
                order.setAddress(customer.getAddress());
                order.setPaymentMethod("Cash on delivery");
                order.setStatus("In-Progress");
                order.setDate(new java.sql.Date(System.currentTimeMillis()));
                order.setAmount(cartItem.getProduct().getProductCost().getSellingPrice()*cartItem.getQuantity());
                order.setProductVariation(productVariation);
                order.setProduct(cartItem.getProduct());
                order.setQuantity(cartItem.getQuantity());
                orderRepository.save(order);
                
                orderItemsStatus.add(new OrderStatus(cartItem,"ordered"));

                // Add the order to the customer's orders
                customer.getOrder().add(order);

                // Remove the item from the cart
                customer.getCartItem().remove(cartItem);

            } else {
            	orderItemsStatus.add(new OrderStatus(cartItem,"Quantity should be less than Avaliable Quantity : "+ productVariation.getProductQuantity().getAvailableQuantity()));
            }
        }
        
        customerRepository.save(customer);

        return new OrderResponse(orderItemsStatus);
    }
    
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return customerRepository.findById(customerId).get().getOrder();
    }
}
