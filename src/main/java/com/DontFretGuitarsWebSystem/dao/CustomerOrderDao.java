package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.CustomerOrder;

import java.util.List;

/**
 * Created by danielwalker on 07/05/2016.
 */

// customerOrder Dao interface
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder); // method to create the order

    List<CustomerOrder> getAllOrders(); // Method to retrieve all orders made on the system.
}
