package com.joranbergfeld.orderservice;

import java.util.StringJoiner;

public class CreateOrderRequest {

    private String userId;
    private String productId;
    private int amount;

    public static Order toOrder(CreateOrderRequest request) {
        if (request == null) {
            return null;
        }

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setAmount(request.getAmount());
        return order;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateOrderRequest.class.getSimpleName() + "[", "]")
            .add("userId='" + userId + "'")
            .add("productId='" + productId + "'")
            .add("amount=" + amount)
            .toString();
    }
}
