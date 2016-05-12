package com.DontFretGuitarsWebSystem.dao.impl;

import com.DontFretGuitarsWebSystem.dao.CartItemDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by danielwalker on 05/05/2016.
 */

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem); // if Hibernate finds a primary key for the same object already exists, then update the object
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    // Fetch this cart item with this product id from the db
    public CartItem getCartItemByProductId (int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where ProductId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }

}
