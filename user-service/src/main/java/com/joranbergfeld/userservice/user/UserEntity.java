package com.joranbergfeld.userservice.user;

import com.joranbergfeld.userservice.domain.Address;
import com.joranbergfeld.userservice.domain.User;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static User toUser(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        Address billingAddress = new Address();
        billingAddress.setCity(entity.getBillingCity());
        billingAddress.setCountry(entity.getBillingCountry());
        billingAddress.setPostcode(entity.getBillingPostcode());
        billingAddress.setState(entity.getBillingState());
        billingAddress.setStreet(entity.getBillingStreet());

        Address homeAddress = new Address();
        homeAddress.setStreet(entity.getHomeStreet());
        homeAddress.setState(entity.getHomeState());
        homeAddress.setPostcode(entity.getHomePostcode());
        homeAddress.setCountry(entity.getHomeCountry());
        homeAddress.setCity(entity.getHomeCity());

        User user = new User();
        user.setEmail(entity.getEmail());
        user.setId(entity.getId());
        user.setPassword(entity.getPassword());
        user.setBillingAddress(billingAddress);
        user.setHomeAddress(homeAddress);

        return user;
    }

    public static UserEntity fromUser(User user) {
        if (user == null) {
            return null;
        }

        UserEntity entity = new UserEntity();

        if (user.getBillingAddress() != null) {
            entity.setBillingCity(user.getBillingAddress().getCity());
            entity.setBillingCountry(user.getBillingAddress().getCountry());
            entity.setBillingPostcode(user.getBillingAddress().getPostcode());
            entity.setBillingState(user.getBillingAddress().getState());
            entity.setBillingStreet(user.getBillingAddress().getStreet());
        }

        if (user.getHomeAddress() != null) {
            entity.setHomeCity(user.getHomeAddress().getCity());
            entity.setHomeCountry(user.getHomeAddress().getCountry());
            entity.setHomePostcode(user.getHomeAddress().getPostcode());
            entity.setHomeState(user.getHomeAddress().getState());
            entity.setHomeStreet(user.getHomeAddress().getStreet());
        }

        entity.setId(user.getId());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());

        return entity;
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
        return new StringJoiner(", ", UserEntity.class.getSimpleName() + "[", "]")
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
