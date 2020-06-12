package com.joranbergfeld.orderservice;

import java.util.StringJoiner;

public class OrderResponse {

    private long id;
    private String userId;
    private String productId;
    private int amount;
    private String status;

    public static OrderResponse fromOrder(Order order) {
        if (order == null) {
            return null;
        }

        OrderResponse response = new OrderResponse();
        response.setAmount(order.getAmount());
        response.setId(order.getId());
        response.setProductId(order.getProductId());
        response.setStatus(order.getStatus().name());
        response.setUserId(order.getUserId());

        return response;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderResponse.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("userId='" + userId + "'")
            .add("productId='" + productId + "'")
            .add("amount=" + amount)
            .add("status='" + status + "'")
            .toString();
    }
}
