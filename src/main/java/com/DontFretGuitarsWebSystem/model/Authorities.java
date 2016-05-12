package com.DontFretGuitarsWebSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by danielwalker on 01/05/2016.
 * Used with the users model for Spring validation of credentials
 */

@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private int authoritiesId;
    private String username;
    private String authority;

    //============================================ Getters and Setters ===============================================//

    public int getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(int authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    public String getUseranme() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
