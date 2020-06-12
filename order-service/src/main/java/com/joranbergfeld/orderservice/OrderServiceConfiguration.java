package com.joranbergfeld.orderservice;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderServiceConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }

    @Bean
    public OrderService orderService(RestTemplate template, EndpointsConfiguration endpointsConfiguration,
        OrderRepository orderRepository) {
        return new OrderService(template, endpointsConfiguration, orderRepository,
            LoggerFactory.getLogger(OrderService.class));
    }

}
