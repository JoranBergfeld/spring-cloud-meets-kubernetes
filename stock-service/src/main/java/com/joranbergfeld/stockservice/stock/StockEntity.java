package com.joranbergfeld.stockservice.stock;

import com.joranbergfeld.stockservice.domain.Stock;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue
    private long id;
    private String productId;
    private int amountOfProducts;

    public static Stock toStock(StockEntity entity) {

        if (entity == null) {
            return null;
        }
        Stock stock = new Stock();
        stock.setAmountOfProducts(entity.getAmountOfProducts());
        stock.setProductId(entity.getProductId());
        return stock;
    }

    public static StockEntity fromStock(Stock stock) {
        if (stock == null) {
            return null;
        }
        StockEntity entity = new StockEntity();
        entity.setAmountOfProducts(stock.getAmountOfProducts());
        entity.setProductId(stock.getProductId());
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(int amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StockEntity.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("productId='" + productId + "'")
            .add("amountOfProducts=" + amountOfProducts)
            .toString();
    }
}
