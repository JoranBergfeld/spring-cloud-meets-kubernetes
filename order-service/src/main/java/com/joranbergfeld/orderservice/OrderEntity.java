package com.joranbergfeld.orderservice;

import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private String productId;
    private int amount;
    private String status;

    public static Order toOrder(OrderEntity entity) {
        if (entity == null) {
            return null;
        }

        Order order = new Order();
        order.setAmount(entity.getAmount());
        order.setId(entity.getId());
        order.setProductId(entity.getProductId());
        order.setUserId(entity.getUserId());
        order.setStatus(OrderStatus.valueOf(entity.getStatus()));
        return order;
    }

    public static OrderEntity fromOrder(Order order) {
        if (order == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setAmount(order.getAmount());
        entity.setId(order.getId());
        entity.setProductId(order.getProductId());
        entity.setUserId(order.getUserId());
        entity.setStatus(order.getStatus().name());
        return entity;
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
        return new StringJoiner(", ", OrderEntity.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("userId='" + userId + "'")
            .add("productId='" + productId + "'")
            .add("amount=" + amount)
            .add("status='" + status + "'")
            .toString();
    }
}
