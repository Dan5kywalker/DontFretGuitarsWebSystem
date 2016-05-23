package com.DontFretGuitarsWebSystem.controller;

import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.model.CustomerOrder;
import com.DontFretGuitarsWebSystem.service.CartService;
import com.DontFretGuitarsWebSystem.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by danielwalker on 07/05/2016.
 */

// Controller action to create the order from the cart
@Controller
public class OrderController {

    // Wire bean to get the cart by it's ID
    @Autowired
    private CartService cartService;

    // Wire bean to get the cart grand total and create the order
    @Autowired
    private CustomerOrderService customerOrderService;

    // Controller method to create the order
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId")int cartId) {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrderService.addCustomerOrder(customerOrder);

        return"redirect:/checkout?cartId="+cartId;
    }
}
