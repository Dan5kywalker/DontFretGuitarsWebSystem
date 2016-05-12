package com.DontFretGuitarsWebSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by danielwalker on 01/05/2016.
 */

// The customer model entity and associated fields and methods

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 4139090973450978910L;

    // Unique customer id
    @Id
    @GeneratedValue
    private int customerId;

    // @NotEmpty annotation ensures the field for registering the customer is not empty
    // Customer first name
    @NotEmpty(message = "The first name field must not be empty.")
    private String firstName;

    // Customer surname
    @NotEmpty(message = "The second name field must not be empty.")
    private String secondName;

    // customers email
    @NotEmpty(message = "The email field must not be empty.")
    private String email;

    // Customers phone number
    private String phoneNo;

    // Customers username for security validation
    @NotEmpty(message = "The username field must not be null")
    private String username;

    // customers password
    @NotEmpty(message = "The password field must not be empty.")
    private String password;

    // customers street name
    @NotEmpty(message = "Customer must disclose address details")
    private String streetName;

    // customers house name
    @NotEmpty(message = "Customer must disclose address details")
    private String houseName;

    // customers city
    @NotEmpty(message = "Customer must disclose address details")
    private String city;

    // customers county
    @NotEmpty(message = "Customer must disclose address details")
    private String county;

    // customers postcode
    @NotEmpty(message = "Customer must disclose address details")
    private String postCode;

    // Boolean variable for customer management
    private boolean enabled;

    // Assign a cart to this customer
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    //============================================ Getters and Setters ===============================================//

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "streetName='" + streetName + '\'' +
                ", houseName='" + houseName + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

}
