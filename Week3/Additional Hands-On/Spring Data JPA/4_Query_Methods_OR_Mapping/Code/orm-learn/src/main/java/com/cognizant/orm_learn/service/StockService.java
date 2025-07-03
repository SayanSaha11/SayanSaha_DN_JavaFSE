// File: com/cognizant/orm_learn/service/StockService.java
package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getFacebookStocksInSep2019() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2019-09-01");
        Date endDate = sdf.parse("2019-09-30");
        return stockRepository.findByCodeAndDateBetween("FB", startDate, endDate);
    }

    @Transactional
    public List<Stock> getGoogleStocksGreaterThan1250() {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
    }

    @Transactional
    public List<Stock> getTop3HighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getTop3LowestNetflixStocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
