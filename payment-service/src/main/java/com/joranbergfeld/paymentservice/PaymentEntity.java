package com.joranbergfeld.paymentservice;

import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productId;
    private String userId;
    private String orderId;
    private String status;

    public static Payment toPayment(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setId(entity.getId());
        payment.setProductId(entity.getProductId());
        payment.setUserId(entity.getUserId());
        payment.setStatus(PaymentStatus.valueOf(entity.getStatus()));
        payment.setOrderId(entity.getOrderId());
        return payment;
    }

    public static PaymentEntity fromPayment(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setProductId(payment.getProductId());
        entity.setUserId(payment.getUserId());
        entity.setStatus(payment.getStatus().name());
        entity.setOrderId(payment.getOrderId());
        return entity;
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
        return new StringJoiner(", ", PaymentEntity.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("productId='" + productId + "'")
            .add("userId='" + userId + "'")
            .add("orderId='" + orderId + "'")
            .add("status='" + status + "'")
            .toString();
    }
}
