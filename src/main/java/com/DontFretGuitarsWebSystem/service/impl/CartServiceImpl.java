package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.CartDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by danielwalker on 05/05/2016.
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart) {
        cartDao.update(cart);
    }

}
