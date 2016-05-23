package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.CustomerOrderDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;
import com.DontFretGuitarsWebSystem.model.CustomerOrder;
import com.DontFretGuitarsWebSystem.service.CartService;
import com.DontFretGuitarsWebSystem.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danielwalker on 07/05/2016.
 */

// Service implementor for the customerOrder class

@Service // Register this service as a spring bean
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired // Wire bean to use the dao object
    private CustomerOrderDao customerOrderDao;

    @Autowired // Wire bean to use the cart service
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) { //method to create the order
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal (int cartId) { // method to get the value of the order total
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems ) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }

    public List<CustomerOrder> getAllOrders(){ return customerOrderDao.getAllOrders();} // Method to retrieve all orders from the db as a list
}
