package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.repositories.AccountRepository;
import batchfour.teamtwo.renttrailservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends  EntityServiceImpl<Account, Long> implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService service;

    @Override
    protected JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email).orElseThrow();
    }
}
