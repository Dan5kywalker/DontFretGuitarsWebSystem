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

// Register this service as a spring bean
@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }
}
