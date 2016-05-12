package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Customer;
import java.util.List;

/**
 * Created by danielwalker on 03/05/2016.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
}
