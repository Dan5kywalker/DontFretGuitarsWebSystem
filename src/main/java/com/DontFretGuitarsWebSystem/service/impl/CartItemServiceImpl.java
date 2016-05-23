package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.CartItemDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;
import com.DontFretGuitarsWebSystem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by danielwalker on 05/05/2016.
 */

// Service implementor for the cartItem class

@Service // Register this service as a spring bean
public class CartItemServiceImpl implements CartItemService{

    @Autowired // Wire bean to use the dao object
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) { // Method to add an item to the cart
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) { // method to remove an item from the cart
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) { // Method to remove all cart items
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productId) { // method to get the cart item by it's id
        return cartItemDao.getCartItemByProductId(productId);
    }
}
