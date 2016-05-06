package com.DontFretGuitarsWebSystem.dao.impl;

import com.DontFretGuitarsWebSystem.dao.CartDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by danielwalker on 05/05/2016.
 */

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Cart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
         // TODO add functionality to update the grand total of the cart.
    }

}
