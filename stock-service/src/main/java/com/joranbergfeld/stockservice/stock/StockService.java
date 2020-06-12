package com.joranbergfeld.stockservice.stock;

import com.joranbergfeld.stockservice.domain.Stock;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock getStockByProductId(final String productId) {
        return this.stockRepository.findByProductId(productId).map(StockEntity::toStock).orElse(null);
    }

    public List<Stock> getAllStocks() {
        return this.stockRepository.findAll().stream().map(StockEntity::toStock).collect(Collectors.toList());
    }

    public Stock createStockForProduct(Stock stock) {
        StockEntity save = this.stockRepository.save(StockEntity.fromStock(stock));
        System.out.println(save.toString());
        return StockEntity.toStock(save);
    }

    public Stock updateStock(final String productId, int changeInProductNumber) {
        Optional<StockEntity> optionalStock = this.stockRepository.findByProductId(productId);
        if (optionalStock.isPresent()) {
            StockEntity stockEntity = optionalStock.get();
            int amountOfProducts = stockEntity.getAmountOfProducts();
            int result = amountOfProducts + changeInProductNumber;
            if (result < 0) {
                return null;
            }
            stockEntity.setAmountOfProducts(result);
            return StockEntity.toStock(this.stockRepository.save(stockEntity));
        }
        return null;
    }
}
