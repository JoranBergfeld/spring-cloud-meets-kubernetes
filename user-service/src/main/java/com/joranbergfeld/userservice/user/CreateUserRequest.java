package com.joranbergfeld.userservice.user;

import com.joranbergfeld.userservice.domain.Address;
import com.joranbergfeld.userservice.domain.User;
import java.util.StringJoiner;

public class CreateUserRequest {

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

    public static User toUser(CreateUserRequest request) {
        if (request == null) {
            return null;
        }

        Address billingAddress = new Address();
        billingAddress.setCity(request.getBillingCity());
        billingAddress.setCountry(request.getBillingCountry());
        billingAddress.setPostcode(request.getBillingPostcode());
        billingAddress.setState(request.getBillingState());
        billingAddress.setStreet(request.getBillingStreet());

        Address homeAddress = new Address();
        homeAddress.setStreet(request.getHomeStreet());
        homeAddress.setState(request.getHomeState());
        homeAddress.setPostcode(request.getHomePostcode());
        homeAddress.setCountry(request.getHomeCountry());
        homeAddress.setCity(request.getHomeCity());

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setBillingAddress(billingAddress);
        user.setHomeAddress(homeAddress);

        return user;
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
        return new StringJoiner(", ", CreateUserRequest.class.getSimpleName() + "[", "]")
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
