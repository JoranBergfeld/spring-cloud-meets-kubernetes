package com.joranbergfeld.userservice.domain;

import java.util.StringJoiner;

/**
 * Simple user domain object.
 */
public class User {

    private long id;
    private String email;
    private String password;
    private Address homeAddress;
    private Address billingAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("email='" + email + "'")
            .add("password='" + password + "'")
            .add("homeAddress=" + homeAddress)
            .add("billingAddress=" + billingAddress)
            .toString();
    }
}
