package com.DontFretGuitarsWebSystem.controller;

import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by danielwalker on 02/05/2016.
 */

// Controller method for registering a new customer as a member of the site
@Controller
public class RegisterController {

    // Wire to CustomerService bean for db persistence actions
    @Autowired
    private CustomerService customerService;

    // Controller action for registering the customer
    @RequestMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    // Registering the customer to the site.
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                                       Model model) {

        // If the binding result flags an error return back to the page
        if(result.hasErrors()) {
            return "registerCustomer";
        }

        // Create a list of the customers through the customerService get method to retrieve the customers from the db
        List<Customer> customerList= customerService.getAllCustomers();

        // Iterate through the customerList to check whether the customer is trying to
        // register with a username or email address that already exists
        for(int i = 0; i<customerList.size(); i++) {

            // If the email being submitted is equal to another email in the customerList
            // return an error message
            if(customer.getEmail().equals(customerList.get(i).getEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "registerCustomer";
            }

            // If the username being submitted is equal to another username in the customerList
            // return an error message
            if(customer.getUsername().equals(customerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "registerCustomer";
            }

        }

        // Set the customer as enabled for customer management
        customer.setEnabled(true);
        // Use the customer service layer to add the customer to the db.
        customerService.addCustomer(customer);

        // Return the success page if the registration was successful
        return "registerCustomerSuccess";

    }


}
