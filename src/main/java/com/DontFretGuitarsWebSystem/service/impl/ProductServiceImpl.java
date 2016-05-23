package com.DontFretGuitarsWebSystem.service.impl;

import com.DontFretGuitarsWebSystem.dao.ProductDao;
import com.DontFretGuitarsWebSystem.model.Product;
import com.DontFretGuitarsWebSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by danielwalker on 02/05/2016.
 */

// service implementor for the product class

@Service // Register this service as a spring bean
public class ProductServiceImpl implements ProductService {

    @Autowired // Wire bean to use the dao object
    private ProductDao productDao;

    // method to get the product by it's id
    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    // method to get all the products from the db through a list
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    // method to add a product to the db
    public void addProduct (Product product) {
        productDao.addProduct(product);
    }

    // method to edit the product's details
    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    // method to delete a product from the db
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

}
