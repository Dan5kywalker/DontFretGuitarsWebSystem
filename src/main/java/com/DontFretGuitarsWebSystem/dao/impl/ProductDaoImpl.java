package com.DontFretGuitarsWebSystem.dao.impl;

import com.DontFretGuitarsWebSystem.dao.ProductDao;
import com.DontFretGuitarsWebSystem.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by danielwalker on 13/04/2016.
 */

// DAO implementor for the product class

@Repository // Indicate this class is a repository, for encapsulating storage, retrieval, and search behavior.
@Transactional // Describe the transaction attributes for this class
public class ProductDaoImpl implements ProductDao {

    @Autowired //Wire bean to Hibernate Session handling.
    private SessionFactory sessionFactory;

    // method to get a particular product by it's id
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    // Method to retrieve all products from the db as a list
    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    // Method to add the product to the db
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    // Method to edit the product
    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    // Method to delete the product from the db
    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
