package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.CustomerOrder;

import java.util.List;


/**
 * Created by danielwalker on 07/05/2016.
 */

// service interface methods for the customerOrder class

public interface CustomerOrderService {

    void addCustomerOrder (CustomerOrder customerOrder); // service method to create an order

    double getCustomerOrderGrandTotal(int cartId); // service method to get the order total

    List<CustomerOrder> getAllOrders(); // service method to get all orders from the db
}
