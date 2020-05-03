package batchfour.teamtwo.renttrailservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import batchfour.teamtwo.renttrailservice.entities.Transaction;
import batchfour.teamtwo.renttrailservice.repositories.TransactionRepository;
import batchfour.teamtwo.renttrailservice.services.TransactionService;

@Service
public class TransactionServiceImpl extends EntityServiceImpl<Transaction, Integer> implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    protected JpaRepository<Transaction, Integer> getRepository() {
        return transactionRepository;
    }

}