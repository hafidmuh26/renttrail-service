package batchfour.teamtwo.renttrailservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import batchfour.teamtwo.renttrailservice.entities.Stock;
import batchfour.teamtwo.renttrailservice.repositories.StockRepository;
import batchfour.teamtwo.renttrailservice.services.StockService;

@Service
public class StockServiceImpl extends EntityServiceImpl<Stock, Integer> implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    protected JpaRepository<Stock, Integer> getRepository() {
        return stockRepository;
    }

}