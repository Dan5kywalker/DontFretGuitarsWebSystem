package com.DontFretGuitarsWebSystem.dao.impl;

import com.DontFretGuitarsWebSystem.dao.CustomerDao;
import com.DontFretGuitarsWebSystem.model.Authorities;
import com.DontFretGuitarsWebSystem.model.Cart;
import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by danielwalker on 03/05/2016.
 */

// DAO implementor for the cartItem class

@Repository // Indicate this class is a repository, for encapsulating storage, retrieval, and search behavior.
@Transactional // Describe the transaction attributes for this class
public class CustomerDaoImpl implements CustomerDao{

    @Autowired //Wire bean for Hibernate Session handling.
    private SessionFactory sessionFactory;

    // Method to add a customer to the db by creating the user, setting their authority as user and assinging them a cart.
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    // Method to get a particular cutomer by thier id.
    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        //return(Customer) session.get(Customer.class, id);
        session.flush();

        return customer;
    }

    // Method to retrieve the list of customers from the db
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }

    // Method to get the customers username by creating a query which will use Hibernate
    // SessionFactory to query the database. The ? is a dynamic variable which is set later to search for
    // a specific username
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);

        return (Customer) query. uniqueResult();
    }

    // method to update the customer details
    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }
}
