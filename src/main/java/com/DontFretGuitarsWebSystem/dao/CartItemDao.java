package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;

/**
 * Created by danielwalker on 05/05/2016.
 */

//CartItem Dao interface

public interface CartItemDao {

    void addCartItem(CartItem cartItem); // Method to add the item to the cart

    void removeCartItem(CartItem cartItem); // Method to remove the item from the cart

    void removeAllCartItems(Cart cart); // Method to remove all cart items

    CartItem getCartItemByProductId(int productId); // Method to get a particular cartItem through the product's id

}
