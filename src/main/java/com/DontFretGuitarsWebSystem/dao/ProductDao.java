package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Product;

import java.util.List;

/**
 * Created by danielwalker on 13/04/2016.
 */

public interface ProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
}
