package com.joranbergfeld.orderservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderResponse>> getOrders() {
        return new ResponseEntity<>(this.orderService.getOrders().stream().map(OrderResponse::fromOrder).collect(
            Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") long id) {
        Optional<Order> optionalOrder = Optional.ofNullable(this.orderService.getOrderById(id));
        return optionalOrder.map(order -> new ResponseEntity<>(OrderResponse.fromOrder(order), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        Optional<Order> optionalOrder = Optional.ofNullable(this.orderService.createOrder(CreateOrderRequest.toOrder(request)));
        return optionalOrder.map(order -> new ResponseEntity<>(OrderResponse.fromOrder(order), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
