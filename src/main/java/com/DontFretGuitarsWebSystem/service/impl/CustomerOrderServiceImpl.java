package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.CustomerOrderDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;
import com.DontFretGuitarsWebSystem.model.CustomerOrder;
import com.DontFretGuitarsWebSystem.service.CartService;
import com.DontFretGuitarsWebSystem.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danielwalker on 07/05/2016.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal (int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems ) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }

    public List<CustomerOrder> getAllOrders(){ return customerOrderDao.getAllOrders();}
}
