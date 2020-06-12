package com.joranbergfeld.productservice.product;

import com.joranbergfeld.productservice.domain.Product;
import java.util.StringJoiner;

public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private int publishedYear;

    public static ProductResponse fromProduct(Product product) {
        if (product == null) {
            return null;
        }

        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setDescription(product.getDescription());
        response.setName(product.getName());
        response.setPublishedYear(product.getPublishedYear());
        return response;
    }

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
        return new StringJoiner(", ", ProductResponse.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .add("description='" + description + "'")
            .add("publishedYear=" + publishedYear)
            .toString();
    }
}
