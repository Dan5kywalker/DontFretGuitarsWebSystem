package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.CustomerDao;
import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by danielwalker on 03/05/2016.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username){
        return customerDao.getCustomerByUsername(username);
    }

}
