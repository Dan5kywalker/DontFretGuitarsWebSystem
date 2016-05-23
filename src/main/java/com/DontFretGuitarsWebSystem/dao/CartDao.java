package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Cart;

import java.io.IOException;

/**
 * Created by danielwalker on 25/04/2016.
 */

// CartDao interface
public interface CartDao {

    Cart getCartById(int cartId); //Interface method to get the cart by it's id

    Cart validate (int cartId) throws IOException; // Interface method to validate the cart by it's id

    void update(Cart cart); // interface method to update the cart

}
