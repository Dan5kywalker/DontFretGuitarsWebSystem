package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Product;

import java.util.List;

/**
 * Created by danielwalker on 13/04/2016.
 */

// Product Dao interface
public interface ProductDao {

    List<Product> getProductList(); // method to retrieve all products from the db in a list

    Product getProductById(int id); // method to retrieve a product by it's id

    void addProduct(Product product); // method to add a product

    void editProduct(Product product); // method to edit a product

    void deleteProduct(Product product); // method to delete a product
}
