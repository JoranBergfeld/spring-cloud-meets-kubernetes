package com.joranbergfeld.productservice.domain;

import java.util.StringJoiner;

public class Product {

    private String id;
    private String name;
    private String description;
    private int publishedYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .add("description='" + description + "'")
            .add("publishedYear=" + publishedYear)
            .toString();
    }
}
