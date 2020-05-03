package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.entities.AuthProvider;
import batchfour.teamtwo.renttrailservice.exceptions.OAuth2AuthenticationProcessingException;
import batchfour.teamtwo.renttrailservice.models.AccountPrincipal;
import batchfour.teamtwo.renttrailservice.models.AccountRequest;
import batchfour.teamtwo.renttrailservice.repositories.AccountRepository;
import batchfour.teamtwo.renttrailservice.services.OAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Transactional
@Service
public class OAuth2ServiceImpl implements OAuth2Service {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public AccountPrincipal process(AccountRequest oAuth2AccountRequest) {
        if (StringUtils.isEmpty(oAuth2AccountRequest.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<Account> accountOptional = accountRepository.findByEmail(oAuth2AccountRequest.getEmail());
        Account account;
        if (accountOptional.isPresent()) {
            account = accountOptional.get();
            if (!account.getProvider().equals(AuthProvider.valueOf(oAuth2AccountRequest.getProvider()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with" +
                        account.getProvider() + " account. Please use your " + account.getProvider() +
                        " account to login.");
            }
            account = updateExistingUser(account, oAuth2AccountRequest);
        } else {
            account = registerNewAccount(oAuth2AccountRequest);
        }
        return AccountPrincipal.create(account);
    }

    private Account registerNewAccount(AccountRequest request) {
        Account account = new Account();

        account.setProvider(AuthProvider.valueOf(request.getProvider()));
        account.setPrviderId(request.getProviderId());
        account.setName(request.getName());
        account.setEmail(request.getEmail());
        account.setPicture(request.getPicture());
        return accountRepository.save(account);
    }

    private Account updateExistingUser(Account existingAccount, AccountRequest oAuth2AccountRequest) {
        existingAccount.setName(oAuth2AccountRequest.getName());
        existingAccount.setPicture(oAuth2AccountRequest.getPicture());
        return accountRepository.save(existingAccount);
    }
}
