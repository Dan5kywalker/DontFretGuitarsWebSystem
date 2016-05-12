package com.DontFretGuitarsWebSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by danielwalker on 25/04/2016.
 */

// The cart model entity and attributes
@Entity
public class Cart implements Serializable {  //Whenever we see Serializable, we are passing this model for the checkout flow

    private static final long serialVersionUID = 1879917799854031735L;

    // cartId
    @Id
    @GeneratedValue
    private int cartId;

    // One cart for many cart items. contain cart items in this cart
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    // Cart is owned by one customer
    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    // Grand total for the cart
    private double grandTotal;

    //============================================ Getters and Setters ===============================================//

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
