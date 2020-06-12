package com.joranbergfeld.orderservice;

import java.util.StringJoiner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order.communication.endpoints")
public class EndpointsConfiguration {

    private String user;
    private String payment;
    private String product;
    private String stock;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EndpointsConfiguration.class.getSimpleName() + "[", "]")
            .add("user='" + user + "'")
            .add("payment='" + payment + "'")
            .add("product='" + product + "'")
            .add("stock='" + stock + "'")
            .toString();
    }
}
