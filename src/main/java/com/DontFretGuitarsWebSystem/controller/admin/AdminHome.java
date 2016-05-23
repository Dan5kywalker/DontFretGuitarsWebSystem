package com.DontFretGuitarsWebSystem.controller.admin;

import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.model.CustomerOrder;
import com.DontFretGuitarsWebSystem.model.Product;
import com.DontFretGuitarsWebSystem.service.CustomerOrderService;
import com.DontFretGuitarsWebSystem.service.CustomerService;
import com.DontFretGuitarsWebSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by danielwalker on 02/05/2016.
 */

// Controller for admin actions for the admin dashboard
@Controller
@RequestMapping ("/admin")
public class AdminHome {

    // Define ProductService Bean to allow for service actions
    @Autowired
    private ProductService productService;

    // Define CustomerService Bean to allow for service actions
    @Autowired
     private CustomerService customerService;

    // Define CustomerOrderService Bean to allow for service actions
    @Autowired
    private CustomerOrderService customerOrderService;

    // Controller action to return the admin page
    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    // Controller action to return the product inventory page when requested
    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    // Controller method to return the customerManagement for managing and viewing the customer list
    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }

    // Controller method to return the orderManagement page to view orders
    @RequestMapping("/orders")
    public String orderManagement(Model model) {
        List<CustomerOrder> orderList = customerOrderService.getAllOrders();
        model.addAttribute("orderList", orderList);

        return "orderManagement";
    }
}
