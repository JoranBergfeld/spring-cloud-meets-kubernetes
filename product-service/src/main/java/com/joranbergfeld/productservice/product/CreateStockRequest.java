package com.joranbergfeld.productservice.product;

import java.util.StringJoiner;

public class CreateStockRequest {
    private String productId;
    private int amountOfProducts;

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

