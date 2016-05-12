package com.DontFretGuitarsWebSystem.controller;

import com.DontFretGuitarsWebSystem.model.Product;
import com.DontFretGuitarsWebSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by danielwalker on 02/05/2016.
 */

// Controller actions for the product model
@Controller
@RequestMapping("/product")
public class ProductController {

    // Wire bean to the product service for db persistence
    @Autowired
    private ProductService productService;

    // Action to retrieve the product list for the product page
    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    // Action to view details for that particular product
    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }

}
