package com.joranbergfeld.stockservice.stock;

import com.joranbergfeld.stockservice.domain.Stock;
import java.util.StringJoiner;

public class StockResponse {

    private String productId;
    private int amountOfProducts;

    public static StockResponse fromStock(Stock stock) {

        if (stock == null) {
            return null;
        }
        StockResponse response = new StockResponse();
        response.setAmountOfProducts(stock.getAmountOfProducts());
        response.setProductId(stock.getProductId());
        return response;
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
        return new StringJoiner(", ", StockResponse.class.getSimpleName() + "[", "]")
            .add("productId='" + productId + "'")
            .add("amountOfProducts=" + amountOfProducts)
            .toString();
    }
}
