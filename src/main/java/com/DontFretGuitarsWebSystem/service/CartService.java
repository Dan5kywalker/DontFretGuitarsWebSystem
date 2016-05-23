package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Cart;

/**
 * Created by danielwalker on 05/05/2016.
 */

// Service interface methods for the cart class

public interface CartService {

    Cart getCartById(int cartId); // service method to get the cart by it's id

    void update(Cart cart); // service method to update the cart
}
