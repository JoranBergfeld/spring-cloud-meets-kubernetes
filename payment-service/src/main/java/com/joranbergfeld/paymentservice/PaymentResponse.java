package com.joranbergfeld.paymentservice;

import java.util.StringJoiner;

public class PaymentResponse {
    private long id;
    private String productId;
    private String userId;
    private String orderId;
    private String status;

    public static PaymentResponse fromPayment(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setProductId(payment.getProductId());
        response.setUserId(payment.getUserId());
        response.setStatus(payment.getStatus().name());
        response.setOrderId(payment.getOrderId());
        return response;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return new StringJoiner(", ", PaymentResponse.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("productId='" + productId + "'")
            .add("userId='" + userId + "'")
            .add("orderId='" + orderId + "'")
            .add("status='" + status + "'")
            .toString();
    }
}
