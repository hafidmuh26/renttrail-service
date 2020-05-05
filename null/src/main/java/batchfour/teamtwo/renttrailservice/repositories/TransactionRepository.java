package batchfour.teamtwo.renttrailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import batchfour.teamtwo.renttrailservice.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}