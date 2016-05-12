package com.DontFretGuitarsWebSystem.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by danielwalker on 01/05/2016.
 */

// The order entity with associated fields and methods
@Entity
public class CustomerOrder implements Serializable{


    private static final long serialVersionUID = 6396520014557501787L;

    // OrderId
    @Id
    @GeneratedValue
    private int customerOrderId;

    // Using the cart for the order
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    // Order belongs to a certain customer
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    //TODO create order status variable

    //============================================ Getters and Setters ===============================================//

    public int getOrderId() {
        return customerOrderId;
    }

    public void setOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}

