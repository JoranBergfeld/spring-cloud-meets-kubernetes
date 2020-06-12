package com.joranbergfeld.userservice.domain;

import java.util.StringJoiner;

/**
 * Simple address domain object.
 * Address information could be somewhat more fine-grained, but for demo purposes I left this out of scope.
 */
public class Address {

    private String street;
    private String postcode;
    private String city;
    private String state;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
            .add("street='" + street + "'")
            .add("postcode='" + postcode + "'")
            .add("city='" + city + "'")
            .add("state='" + state + "'")
            .add("country='" + country + "'")
            .toString();
    }
}
