package com.DontFretGuitarsWebSystem.dao;

import com.DontFretGuitarsWebSystem.model.Product;

import java.util.List;

/**
 * Created by danielwalker on 13/04/2016.
 */

public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
