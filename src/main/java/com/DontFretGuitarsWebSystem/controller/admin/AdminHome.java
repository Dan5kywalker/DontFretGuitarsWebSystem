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

@Controller
@RequestMapping ("/admin")
public class AdminHome {

    // Define ProductService Bean
    @Autowired
    private ProductService productService;

    // Define CustomerService Bean
    @Autowired
     private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    // Controller method for managing and viewing the customer list
    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }

    // Controller method to view and edit order status
    @RequestMapping("/orders")
    public String orderManagement(Model model) {
        List<CustomerOrder> orderList = customerOrderService.getAllOrders();
        model.addAttribute("orderList", orderList);

        return "orderManagement";
    }
}
