package com.DontFretGuitarsWebSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by danielwalker on 25/04/2016.
 */

// CartItem Model entity and associated variables and methods
@Entity
public class CartItem implements Serializable {


    private static final long serialVersionUID = 6035226891067262429L;

    // Each cartItem has an Id
    @Id
    @GeneratedValue
    private int cartItemId;

    // Join cartItem to the cart belonging to the customer
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    // Create the cart item from the product using the product id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    // Variable for the cartItem quantity
    private int quantity;

    // Variable for the totalPrice for that CartItem line.
    private double totalPrice;

    //============================================ Getters and Setters ===============================================//

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
