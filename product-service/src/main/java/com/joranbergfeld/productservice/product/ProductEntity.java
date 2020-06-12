package com.joranbergfeld.productservice.product;


import com.joranbergfeld.productservice.domain.Product;
import java.util.StringJoiner;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private int publishedYear;

    public static Product toProduct(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        Product product = new Product();
        product.setId(entity.getId());
        product.setDescription(entity.getDescription());
        product.setName(entity.getName());
        product.setPublishedYear(entity.getPublishedYear());
        return product;
    }

    public static ProductEntity fromProduct(Product product) {
        if (product == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setDescription(product.getDescription());
        entity.setName(product.getName());
        entity.setPublishedYear(product.getPublishedYear());
        return entity;
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
        return new StringJoiner(", ", ProductEntity.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .add("description='" + description + "'")
            .add("publishedYear=" + publishedYear)
            .toString();
    }
}
