package com.joranbergfeld.stockservice.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.joranbergfeld.stockservice.domain.Stock;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class StockServiceTest {

    private final StockRepository stockRepository = Mockito.mock(StockRepository.class);
    private final StockService stockService = new StockService(stockRepository);

    @Test
    void createStock() {
        final String productId = "product";
        final int amountOfStock = 1;

        StockEntity entity = new StockEntity();
        entity.setAmountOfProducts(amountOfStock);
        entity.setProductId(productId);

        Stock stock = StockEntity.toStock(entity);

        ArgumentCaptor<StockEntity> captor = ArgumentCaptor.forClass(StockEntity.class);

        when(stockRepository.save(any())).thenReturn(entity);

        stockService.createStockForProduct(stock);
        verify(stockRepository, times(1)).save(captor.capture());

        assertEquals(amountOfStock, captor.getValue().getAmountOfProducts());
        assertEquals(productId, captor.getValue().getProductId());
    }

    @Test
    void updateStock() {
        final String productId = "product";
        final int amountOfStock = 1;
        final int changeInStock = -1;

        ArgumentCaptor<StockEntity> captor = ArgumentCaptor.forClass(StockEntity.class);

        StockEntity entity = new StockEntity();
        entity.setAmountOfProducts(amountOfStock);
        entity.setProductId(productId);

        when(stockRepository.save(any())).thenReturn(entity);
        when(stockRepository.findByProductId(productId)).thenReturn(Optional.of(entity));

        stockService.updateStock(productId, changeInStock);

        verify(stockRepository, times(1)).findByProductId(productId);
        verify(stockRepository, times(1)).save(captor.capture());

        assertEquals(0, captor.getValue().getAmountOfProducts(), "Should have reduced stock.");
        assertEquals(productId, captor.getValue().getProductId());
    }
}
