package batchfour.teamtwo.renttrailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import batchfour.teamtwo.renttrailservice.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}