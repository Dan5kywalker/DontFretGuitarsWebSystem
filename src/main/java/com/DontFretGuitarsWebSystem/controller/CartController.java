package com.DontFretGuitarsWebSystem.controller;

import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by danielwalker on 04/05/2016.
 */

// Controller action to display the customers shopping cart
@Controller
@RequestMapping("/customer/cart") // Map the action to this URL route
public class CartController {

    // Autowire bean to customer service for when cart is created for the customer
    @Autowired
    private CustomerService customerService;

    // Display the cart if the cartId exists
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/"+cartId;
    }

    // If the cart exists, return the cart page.
    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId");

        return "cart";
    }

}
