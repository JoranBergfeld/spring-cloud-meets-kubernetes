package com.joranbergfeld.stockservice.stock;

import java.util.StringJoiner;

public class UpdateStockRequest {

    private int deltaInStock;

    public int getDeltaInStock() {
        return deltaInStock;
    }

    public void setDeltaInStock(int deltaInStock) {
        this.deltaInStock = deltaInStock;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateStockRequest.class.getSimpleName() + "[", "]")
            .add("deltaInStock=" + deltaInStock)
            .toString();
    }
}
