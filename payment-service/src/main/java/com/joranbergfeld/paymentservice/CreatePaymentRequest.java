package com.joranbergfeld.paymentservice;

import java.util.StringJoiner;

public class CreatePaymentRequest {

    private String orderId;
    private String productId;
    private String userId;

    public static Payment toPayment(CreatePaymentRequest request) {
        if (request == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setUserId(request.getUserId());
        payment.setProductId(request.getProductId());
        return payment;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
