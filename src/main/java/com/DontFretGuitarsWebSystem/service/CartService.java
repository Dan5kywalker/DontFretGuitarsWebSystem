package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Cart;

/**
 * Created by danielwalker on 05/05/2016.
 */
public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
