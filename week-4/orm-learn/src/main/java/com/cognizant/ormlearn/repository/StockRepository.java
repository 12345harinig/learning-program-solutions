package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Facebook stocks in September 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // 2. Google stocks with close price > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);

    // 3. Top 3 highest volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. 3 lowest Netflix closing prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
