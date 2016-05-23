package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Customer;
import java.util.List;

/**
 * Created by danielwalker on 03/05/2016.
 */

//Customer Dao interface
public interface CustomerDao {

    void addCustomer(Customer customer); // Method to add a customer

    Customer getCustomerById(int customerId); // method to retrieve a customer's details through thier id

    List<Customer> getAllCustomers(); // method to retrieve a lis of all the customers in the db

    Customer getCustomerByUsername (String username); // Method to get a customer through their unique username

    void editCustomer(Customer customer); // method to edit a customer

    void deleteCustomer(Customer customer); // method to delete a customer

}
