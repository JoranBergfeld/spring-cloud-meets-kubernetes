package com.joranbergfeld.productservice.product;

import java.util.StringJoiner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "product.communication.endpoints")
public class EndpointsConfiguration {
    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EndpointsConfiguration.class.getSimpleName() + "[", "]")
            .add("stock='" + stock + "'")
            .toString();
    }
}
