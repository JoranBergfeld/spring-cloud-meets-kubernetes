package com.joranbergfeld.paymentservice;

import java.util.StringJoiner;

public class Payment {

    private long id;
    private String productId;
    private String userId;
    private String orderId;
    private PaymentStatus status = PaymentStatus.PENDING_USER_PAYMENT;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Payment.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("productId='" + productId + "'")
            .add("userId='" + userId + "'")
            .add("orderId='" + orderId + "'")
            .add("status=" + status)
            .toString();
    }
}
