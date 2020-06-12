package com.joranbergfeld.orderservice;

import java.util.StringJoiner;

public class Order {

    private long id;
    private String userId;
    private String productId;
    private int amount;
    private OrderStatus status = OrderStatus.PENDING;

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("userId='" + userId + "'")
            .add("productId='" + productId + "'")
            .add("amount=" + amount)
            .add("status=" + status)
            .toString();
    }
}
