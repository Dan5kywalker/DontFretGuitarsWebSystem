package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;

/**
 * Created by danielwalker on 05/05/2016.
 */

// service interface methods for the cartItem class

public interface CartItemService {

    void addCartItem(CartItem cartItem); // service method to add an item to the cart

    void removeCartItem(CartItem cartItem); // service method to remove an item from the cart

    void removeAllCartItems(Cart cart); // service method to remove all cartItems

    CartItem getCartItemByProductId(int productId); // service method to retrieve a cart item through it's id

}
