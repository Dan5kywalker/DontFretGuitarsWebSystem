package com.DontFretGuitarsWebSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Created by danielwalker on 11/04/2016.
 * Contains all the fields and attributes that represent a product entity
 */

// All models used within the Spring Webflow must implement the Serializable interface
@Entity
public class Product implements Serializable{


    private static final long serialVersionUID = 8238465361722665829L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty (message = "Product must have a name")
    private String productName;
    private String productCategory;
    private String productDescription;

    @Min (value = 0 , message = "The product price must not be less than zero")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min (value = 0, message = "The product unit must not be less than zero")
    private int unitInStock;

    @NotEmpty (message = "Product must have a manufacturer")
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;

    // Indicates the relationship to the cartItem class. the CartItem model is mapped by this product class
    // Cascade type indicates that any operations to the owner or parent of this relationship that it
    // can be cascaded automatically
    // FetchType can be lazy or eager, eager allows it to fetch data from the database.
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JsonIgnore // When Spring is told to convert this object to the Json format, this field will be omitted
    private List<CartItem> cartItemList;

    //============================================ Getters and Setters ===============================================//


    public int getProductId() { return productId; }

    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) { this.productCondition = productCondition; }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
