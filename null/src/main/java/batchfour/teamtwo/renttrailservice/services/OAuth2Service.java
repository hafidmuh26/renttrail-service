package batchfour.teamtwo.renttrailservice.services;

import batchfour.teamtwo.renttrailservice.models.AccountRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OAuth2Service {

    public OAuth2User process(AccountRequest oAuth2UserRequest);

}
