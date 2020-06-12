package com.joranbergfeld.stockservice.stock;


import com.joranbergfeld.stockservice.domain.Stock;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public ResponseEntity<List<StockResponse>> getAllStocks() {
        List<StockResponse> body = stockService.getAllStocks().stream().map(StockResponse::fromStock)
            .collect(Collectors.toList());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/stock/product/{id}")
    public ResponseEntity<StockResponse> getStockByProductId(@PathVariable("id") final String productId) {
        Optional<Stock> optionalStock = Optional.ofNullable(stockService.getStockByProductId(productId));
        return optionalStock.map(stock -> new ResponseEntity<>(StockResponse.fromStock(stock), HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/stock/product/{id}")
    public ResponseEntity<StockResponse> updateStock(@PathVariable("id") final String productId,
        @RequestBody UpdateStockRequest request) {
        Optional<Stock> optionalStock = Optional
            .ofNullable(stockService.updateStock(productId, request.getDeltaInStock()));
        return optionalStock.map(stock -> new ResponseEntity<>(StockResponse.fromStock(stock), HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/stock")
    public ResponseEntity<StockResponse> createStock(@RequestBody CreateStockRequest request) {
        Stock stock = stockService.createStockForProduct(CreateStockRequest.toStock(request));
        return new ResponseEntity<>(StockResponse.fromStock(stock), HttpStatus.CREATED);
    }
}
