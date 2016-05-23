package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.CartDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by danielwalker on 05/05/2016.
 */

// Cart service implementation

@Service
public class CartServiceImpl implements CartService {

    @Autowired // Wire bean to use the dao object
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    } // Method to retrieve the cart by it's id

    public void update(Cart cart) {
        cartDao.update(cart);
    } // Method to update the cart

}
