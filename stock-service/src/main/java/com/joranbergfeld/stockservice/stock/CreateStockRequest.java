package com.joranbergfeld.stockservice.stock;

import com.joranbergfeld.stockservice.domain.Stock;
import java.util.StringJoiner;

public class CreateStockRequest {
    private String productId;
    private int amountOfProducts;

    public static Stock toStock(CreateStockRequest request) {
        if (request == null) {
            return null;
        }

        Stock stock = new Stock();
        stock.setProductId(request.getProductId());
        stock.setAmountOfProducts(request.getAmountOfProducts());
        return stock;
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
        return new StringJoiner(", ", CreateStockRequest.class.getSimpleName() + "[", "]")
            .add("productId='" + productId + "'")
            .add("amountOfProducts=" + amountOfProducts)
            .toString();
    }
}
