package com.joranbergfeld.stockservice.stock;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
    Optional<StockEntity> findByProductId(final String productId);
}
