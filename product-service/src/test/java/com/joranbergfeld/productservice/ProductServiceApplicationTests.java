package com.joranbergfeld.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.joranbergfeld.productservice.product.CreateProductRequest;
import com.joranbergfeld.productservice.product.ProductResponse;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Test
    void createProduct() {
        final String baseUrl = "http://localhost:" + port;
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();

        final String expectedDescription = "This is a test product.";
        final String expectedName = "TestProduct#1";
        int expectedYear = 2020;

        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setDescription(expectedDescription);
        createProductRequest.setName(expectedName);
        createProductRequest.setPublishedYear(expectedYear);

        ResponseEntity<ProductResponse> productResponseResponseEntity = restTemplate
            .postForEntity("/product", createProductRequest, ProductResponse.class, Collections.emptyMap());

        assertEquals(productResponseResponseEntity.getStatusCode(), HttpStatus.CREATED,
            "Should return HTTP Status 201.");

        assertNotNull(productResponseResponseEntity.getBody());
        ProductResponse body = productResponseResponseEntity.getBody();

        assertEquals(expectedYear, body.getPublishedYear());
        assertEquals(expectedDescription, body.getDescription());
        assertEquals(expectedName, body.getName());
    }

}


