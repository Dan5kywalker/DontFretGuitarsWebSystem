package com.DontFretGuitarsWebSystem.dao.impl;

import com.DontFretGuitarsWebSystem.dao.CustomerOrderDao;
import com.DontFretGuitarsWebSystem.model.CustomerOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by danielwalker on 07/05/2016.
 */

// DAO implementor for the customerOrder class

@Repository // Indicate this class is a repository, for encapsulating storage, retrieval, and search behavior.
@Transactional // Describe the transaction attributes for this class
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired //Wire bean to Hibernate Session handling.
    private SessionFactory sessionFactory;

    // Method to add the order to the db
    public void addCustomerOrder(CustomerOrder customerOrder){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    // Method to fetch all orders from the db as a list
    public List<CustomerOrder> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");
        List<CustomerOrder> orderList = query.list();

        return orderList;
    }

}
