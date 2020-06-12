package com.joranbergfeld.productservice.product;

import com.joranbergfeld.productservice.domain.Product;
import java.util.StringJoiner;

public class CreateProductRequest {
    private String name;
    private String description;
    private int publishedYear;

    public static Product toProduct(CreateProductRequest request) {
        if (request == null) {
            return null;
        }

        Product product = new Product();
        product.setPublishedYear(request.getPublishedYear());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        return product;
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
        return new StringJoiner(", ", CreateProductRequest.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("description='" + description + "'")
            .add("publishedYear=" + publishedYear)
            .toString();
    }
}
