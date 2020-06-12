package com.joranbergfeld.orderservice;

import java.util.StringJoiner;

public class ChangeStockRequest {
    private int deltaInStock;

    public int getDeltaInStock() {
        return deltaInStock;
    }

    public void setDeltaInStock(int deltaInStock) {
        this.deltaInStock = deltaInStock;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChangeStockRequest.class.getSimpleName() + "[", "]")
            .add("deltaInStock=" + deltaInStock)
            .toString();
    }
}
