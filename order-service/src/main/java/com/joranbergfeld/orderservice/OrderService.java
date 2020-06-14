package com.joranbergfeld.orderservice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final EndpointsConfiguration endpointsConfiguration;
    private final OrderRepository orderRepository;

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(RestTemplate restTemplate,
        EndpointsConfiguration endpointsConfiguration, OrderRepository orderRepository) {
        this.restTemplate = restTemplate;
        this.endpointsConfiguration = endpointsConfiguration;
        this.orderRepository = orderRepository;

        logger.info("Endpoints configured wired into OrderService: " + endpointsConfiguration.toString());
    }

    public List<Order> getOrders() {
        return this.orderRepository.findAll().stream().map(OrderEntity::toOrder).collect(Collectors.toList());
    }

    public Order getOrderById(long id) {
        return this.orderRepository.findById(id).map(OrderEntity::toOrder).orElse(null);
    }

    public Order createOrder(Order order) {
        // check user id
        final String userId = order.getUserId();
        final String productId = order.getProductId();
        int amount = order.getAmount();
        if (!validUserId(userId)) {
            return null;
        }

        // check if product is valid
        if (!checkIfProductExists(productId)) {
            return null;
        }

        boolean changeStockSuccessfully = changeStockForOrder(productId, amount);
        if (!changeStockSuccessfully) {
            return null;
        }


        // all preconditions are checked and stock has changed, create payment
        logger.info(
            "Preconditions for order from user " + userId + " for product " + productId + " have passed Proceeding...");
        OrderEntity saved = this.orderRepository.save(OrderEntity.fromOrder(order));
        boolean paymentCreated = createPayment(OrderEntity.toOrder(saved));

        if (!paymentCreated) {
            return null;
        }
        return OrderEntity.toOrder(saved);
    }

    private boolean createPayment(Order order) {
        CreatePaymentRequest request = new CreatePaymentRequest();
        request.setOrderId(order.getId());
        request.setUserId(order.getUserId());
        request.setProductId(order.getProductId());

        ResponseEntity<String> paymentCreationEntity = restTemplate
            .postForEntity(endpointsConfiguration.getPayment() + "/payment", request, String.class,
                Collections.emptyMap());

        return paymentCreationEntity.getStatusCode().is2xxSuccessful();
    }

    private boolean validUserId(String userId) {
        ResponseEntity<String> userEntity = restTemplate
            .getForEntity(endpointsConfiguration.getUser() + "/user/" + userId, String.class, Collections.emptyMap());

        return userEntity.getStatusCode().is2xxSuccessful();
    }

    private boolean checkIfProductExists(final String productId) {
        ResponseEntity<String> productEntity = restTemplate
            .getForEntity(endpointsConfiguration.getProduct() + "/product/" + productId, String.class,
                Collections.emptyMap());

        return productEntity.getStatusCode().is2xxSuccessful();
    }

    private boolean changeStockForOrder(String productId, int amount) {
        ChangeStockRequest changeStockRequest = new ChangeStockRequest();
        changeStockRequest.setDeltaInStock(-amount);

        final String url = endpointsConfiguration.getStock() + "/stock/product/" + productId;

        ResponseEntity<String> stockUpdateEntity = restTemplate
            .exchange(url, HttpMethod.POST,
                new HttpEntity<>(changeStockRequest), String.class, Collections
                    .emptyMap());

        return stockUpdateEntity.getStatusCode().is2xxSuccessful();
    }
}
