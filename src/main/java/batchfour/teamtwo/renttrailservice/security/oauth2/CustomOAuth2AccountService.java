package batchfour.teamtwo.renttrailservice.security.oauth2;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.exceptions.OAuth2AuthenticationProcessingException;
import batchfour.teamtwo.renttrailservice.entities.AuthProvider;
import batchfour.teamtwo.renttrailservice.repositories.AccountRepository;
import batchfour.teamtwo.renttrailservice.security.AccountPrincipal;
import batchfour.teamtwo.renttrailservice.security.oauth2.user.OAuth2AccountInfo;
import batchfour.teamtwo.renttrailservice.security.oauth2.user.OAuth2AccountInfoFactory;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import org.springframework.security.core.AuthenticationException;
import java.util.Optional;

@Service
public class CustomOAuth2AccountService extends DefaultOAuth2UserService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest accountRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(accountRequest);

        try {
            return processOAuth2User(accountRequest, oAuth2User);
        } catch (AuthenticationException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) throws OAuth2AuthenticationProcessingException {
        OAuth2AccountInfo oAuth2AccountInfo = OAuth2AccountInfoFactory.getOAuth2AccountInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(),oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2AccountInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<Account> accountOptional = accountRepository.findByEmail(oAuth2AccountInfo.getEmail());
        Account account;
        if (accountOptional.isPresent()) {
            account = accountOptional.get();
            if (!account.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " + account.getProvider() +
                        " account. Please use your " + account.getProvider() + " account to login.");
            }

            account = updateExistingUser(account, oAuth2AccountInfo);
        } else {
            account = registerNewAccount(oAuth2UserRequest, oAuth2AccountInfo);
        }

        return AccountPrincipal.create(account, oAuth2User.getAttributes());
    }

    private Account registerNewAccount(OAuth2UserRequest oAuth2UserRequest, OAuth2AccountInfo oAuth2AccountInfo) {
        Account account = new Account();

        account.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        account.setPrviderId(oAuth2AccountInfo.getId());
        account.setName(oAuth2AccountInfo.getName());
        account.setEmail(oAuth2AccountInfo.getEmail());

        return accountRepository.save(account);
    }

    private Account updateExistingUser(Account exitingUser, OAuth2AccountInfo oAuth2AccountInfo) {
        exitingUser.setName(oAuth2AccountInfo.getName());
        return accountRepository.save(exitingUser);
    }


}
