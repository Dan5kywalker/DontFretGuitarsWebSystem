package com.DontFretGuitarsWebSystem.dao.impl;

import com.DontFretGuitarsWebSystem.dao.CartDao;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by danielwalker on 05/05/2016.
 */

// DAO implementor for the cart class

@Repository // Indicate this class is a repository, for encapsulating storage, retrieval, and search behavior.
@Transactional // Describe the transaction attributes for this class
public class CartDaoImpl implements CartDao {

    @Autowired  //Wire bean to Hibernate Session handling.
    private SessionFactory sessionFactory;

    @Autowired //Wire bean for dependencies within the customerOrder
    private CustomerOrderService customerOrderService;

    // Method to retrieve the users cart by an id
    public Cart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    // Method to update the users cart, for example, removing or adding an item.
    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    // Method to ensure the users cart is valid
    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if(cart == null||cart.getCartItems().size()==0){
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }

}
