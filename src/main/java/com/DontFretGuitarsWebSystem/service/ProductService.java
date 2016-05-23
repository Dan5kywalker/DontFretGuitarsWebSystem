package com.DontFretGuitarsWebSystem.service;

import com.DontFretGuitarsWebSystem.model.Product;

import java.util.List;

/**
 * Created by danielwalker on 02/05/2016.
 */

// service interface methods for the product class

public interface ProductService {

    List<Product> getProductList(); // service method to get all product from the db

    Product getProductById(int id); // service method to get a product by it's id

    void addProduct(Product product); // service method to add  product to the db

    void editProduct(Product product); // service method to edit a product

    void deleteProduct(Product product); // service method to delete a product on the db
}
