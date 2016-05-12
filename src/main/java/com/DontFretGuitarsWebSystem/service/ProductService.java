package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Product;

import java.util.List;

/**
 * Created by danielwalker on 02/05/2016.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
