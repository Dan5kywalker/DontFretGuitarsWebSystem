package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.CustomerOrder;

import java.util.List;

/**
 * Created by danielwalker on 07/05/2016.
 */
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllOrders();
}
