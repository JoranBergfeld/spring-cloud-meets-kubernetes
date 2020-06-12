package com.joranbergfeld.userservice.user;

import com.joranbergfeld.userservice.domain.Address;
import com.joranbergfeld.userservice.domain.User;
import java.util.StringJoiner;

public class UserResponse {

    private long id;
    private String email;
    private String password;
    private String billingStreet;
    private String billingPostcode;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String homeStreet;
    private String homePostcode;
    private String homeCity;
    private String homeState;
    private String homeCountry;

    public static User toUser(UserResponse response) {
        if (response == null) {
            return null;
        }

        Address billingAddress = new Address();
        billingAddress.setCity(response.getBillingCity());
        billingAddress.setCountry(response.getBillingCountry());
        billingAddress.setPostcode(response.getBillingPostcode());
        billingAddress.setState(response.getBillingState());
        billingAddress.setStreet(response.getBillingStreet());

        Address homeAddress = new Address();
        homeAddress.setStreet(response.getHomeStreet());
        homeAddress.setState(response.getHomeState());
        homeAddress.setPostcode(response.getHomePostcode());
        homeAddress.setCountry(response.getHomeCountry());
        homeAddress.setCity(response.getHomeCity());

        User user = new User();
        user.setEmail(response.getEmail());
        user.setId(response.getId());
        user.setPassword(response.getPassword());
        user.setBillingAddress(billingAddress);
        user.setHomeAddress(homeAddress);

        return user;
    }

    public static UserResponse fromUser(User user) {
        if (user == null) {
            return null;
        }

        UserResponse response = new UserResponse();

        if (user.getBillingAddress() != null) {
            response.setBillingCity(user.getBillingAddress().getCity());
            response.setBillingCountry(user.getBillingAddress().getCountry());
            response.setBillingPostcode(user.getBillingAddress().getPostcode());
            response.setBillingState(user.getBillingAddress().getState());
            response.setBillingStreet(user.getBillingAddress().getStreet());
        }

        if (user.getHomeAddress() != null) {
            response.setHomeCity(user.getHomeAddress().getCity());
            response.setHomeCountry(user.getHomeAddress().getCountry());
            response.setHomePostcode(user.getHomeAddress().getPostcode());
            response.setHomeState(user.getHomeAddress().getState());
            response.setHomeStreet(user.getHomeAddress().getStreet());
        }

        response.setId(user.getId());
        response.setPassword(user.getPassword());
        response.setEmail(user.getEmail());

        return response;
    }

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

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingPostcode() {
        return billingPostcode;
    }

    public void setBillingPostcode(String billingPostcode) {
        this.billingPostcode = billingPostcode;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getHomeStreet() {
        return homeStreet;
    }

    public void setHomeStreet(String homeStreet) {
        this.homeStreet = homeStreet;
    }

    public String getHomePostcode() {
        return homePostcode;
    }

    public void setHomePostcode(String homePostcode) {
        this.homePostcode = homePostcode;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserResponse.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("email='" + email + "'")
            .add("password='" + password + "'")
            .add("billingStreet='" + billingStreet + "'")
            .add("billingPostcode='" + billingPostcode + "'")
            .add("billingCity='" + billingCity + "'")
            .add("billingState='" + billingState + "'")
            .add("billingCountry='" + billingCountry + "'")
            .add("homeStreet='" + homeStreet + "'")
            .add("homePostcode='" + homePostcode + "'")
            .add("homeCity='" + homeCity + "'")
            .add("homeState='" + homeState + "'")
            .add("homeCountry='" + homeCountry + "'")
            .toString();
    }
}
