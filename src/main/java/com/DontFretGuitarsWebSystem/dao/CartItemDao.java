package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;

/**
 * Created by danielwalker on 05/05/2016.
 */
public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}
