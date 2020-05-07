package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.exceptions.ResourceNotFoundException;
import batchfour.teamtwo.renttrailservice.models.AccountRequest;
import batchfour.teamtwo.renttrailservice.repositories.AccountRepository;
import batchfour.teamtwo.renttrailservice.models.AccountPrincipal;
import batchfour.teamtwo.renttrailservice.validation.annotations.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("account/me")
    @PreAuthorize("hasRole('USER')")
    public Account getCurrentAccount(@CurrentUser AccountRequest accountPrincipal) {
        return accountRepository.findById(accountPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountPrincipal.getId()));
    }
}
