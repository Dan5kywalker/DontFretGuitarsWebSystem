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

// DAO implementor for the cartItem class

@Repository // Indicate this class is a repository, for encapsulating storage, retrieval, and search behavior.
@Transactional // Describe the transaction attributes for this class
public class CartItemDaoImpl implements CartItemDao {

    @Autowired  //Wire bean to Hibernate Session handling.
    private SessionFactory sessionFactory;

    // Method to add an item to the users cart
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem); // if Hibernate finds a primary key for the same object already exists, then update the object quantity
        session.flush();
    }

    // Method remove the item from the cart
    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    // Method to clear the cart
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
