package com.DontFretGuitarsWebSystem.controller;

import com.DontFretGuitarsWebSystem.dao.ProductDao;
import com.DontFretGuitarsWebSystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by danielwalker on 10/04/2016.
 */

@Controller
public class HomeController {

    // Define the instance of the product data access object for use in the controller
    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    // Bind the data in the dao to the model for the productListView
    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productList";
    }

    // Controller action to display details of the product
    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {

        // Function returns the product with this matching id
        Product product = productDao.getProductById(productId);
        model.addAttribute(product); //Attach this project to the model which will be returned to the view

        return "viewProduct";
    }
}
