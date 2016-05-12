package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Cart;

import java.io.IOException;

/**
 * Created by danielwalker on 25/04/2016.
 */
public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate (int cartId) throws IOException;

    void update(Cart cart);



}
