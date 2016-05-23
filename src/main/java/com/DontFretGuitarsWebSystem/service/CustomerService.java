package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Customer;
import java.util.List;

/**
 * Created by danielwalker on 03/05/2016.
 */

// service interface methods for the customer class

public interface CustomerService {

    void addCustomer(Customer customer); // service method to add a customer to the db

    Customer getCustomerById(int id); // service method to get the customer by their id

    List<Customer> getAllCustomers(); // service method to get all customers in the db

    Customer getCustomerByUsername (String username); // service method to get all customer on a list stored on the db

    void editCustomer(Customer customer); // service method to edit a customer on the db

}
