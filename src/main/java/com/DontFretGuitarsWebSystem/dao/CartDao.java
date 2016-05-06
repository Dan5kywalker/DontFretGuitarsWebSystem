package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Cart;

/**
 * Created by danielwalker on 25/04/2016.
 */
public interface CartDao {

    Cart getCartById(int cartId);

    void update(Cart cart);

}
