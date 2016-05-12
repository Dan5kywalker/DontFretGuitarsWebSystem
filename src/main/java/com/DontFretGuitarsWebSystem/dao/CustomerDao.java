package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Customer;
import java.util.List;

/**
 * Created by danielwalker on 03/05/2016.
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);

}
