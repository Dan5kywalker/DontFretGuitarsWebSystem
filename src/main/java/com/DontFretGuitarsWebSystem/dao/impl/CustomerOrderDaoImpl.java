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

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    public List<CustomerOrder> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");
        List<CustomerOrder> orderList = query.list();

        return orderList;
    }

}
