package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.CustomerOrder;

import java.util.List;


/**
 * Created by danielwalker on 07/05/2016.
 */
public interface CustomerOrderService {

    void addCustomerOrder (CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);

    List<CustomerOrder> getAllOrders();
}
