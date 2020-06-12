package com.joranbergfeld.orderservice;

import java.util.StringJoiner;

public class CreatePaymentRequest {
    private long orderId;
    private String productId;
    private String userId;
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", CreatePaymentRequest.class.getSimpleName() + "[", "]")
            .add("orderId='" + orderId + "'")
            .add("productId='" + productId + "'")
            .add("userId='" + userId + "'")
            .toString();
    }
}
