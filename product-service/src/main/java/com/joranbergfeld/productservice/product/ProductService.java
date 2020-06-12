package com.joranbergfeld.productservice.product;

import com.joranbergfeld.productservice.domain.Product;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final EndpointsConfiguration endpointsConfiguration;
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public ProductService(EndpointsConfiguration endpointsConfiguration,
        ProductRepository productRepository, RestTemplate restTemplate) {
        this.endpointsConfiguration = endpointsConfiguration;
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts() {
        return this.productRepository.findAll().stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    public Product getProductById(final String id) {
        return this.productRepository.findById(id).map(ProductEntity::toProduct).orElse(null);
    }

    public Product createProduct(Product product) {
        ProductEntity entity = ProductEntity.fromProduct(product);
        Product savedProduct = ProductEntity.toProduct(this.productRepository.save(entity));
        boolean createdStock = createStockForProduct(savedProduct, 100);
        if (createdStock) {
            return savedProduct;
        } else {
            this.productRepository.delete(ProductEntity.fromProduct(savedProduct));
            return null;
        }
    }

    private boolean createStockForProduct(Product createdProduct, int initialStockSize) {
        final String url = endpointsConfiguration.getStock() + "/stock";
        CreateStockRequest request = new CreateStockRequest();
        request.setProductId(createdProduct.getId());
        request.setAmountOfProducts(initialStockSize);
        ResponseEntity<String> stringResponseEntity = this.restTemplate
            .postForEntity(url, request, String.class, Collections.emptyMap());
        return stringResponseEntity.getStatusCode().is2xxSuccessful();
    }
}
