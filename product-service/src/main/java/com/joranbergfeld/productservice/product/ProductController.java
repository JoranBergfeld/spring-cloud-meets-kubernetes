package com.joranbergfeld.productservice.product;

import com.joranbergfeld.productservice.domain.Product;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getProducts().stream().map(ProductResponse::fromProduct)
            .collect(Collectors.toList());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") final String id) {
        Optional<Product> productById = Optional.ofNullable(productService.getProductById(id));
        return productById.map(product -> new ResponseEntity<>(ProductResponse.fromProduct(product), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        Product product = productService.createProduct(CreateProductRequest.toProduct(request));
        return new ResponseEntity<>(ProductResponse.fromProduct(product), HttpStatus.CREATED);
    }
}
