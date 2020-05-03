package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.models.AccountPrincipal;
import batchfour.teamtwo.renttrailservice.models.AccountRequest;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.security.TokenProvider;
import batchfour.teamtwo.renttrailservice.services.OAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oauth")
public class OAuth2Controller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    OAuth2Service oAuth2Service;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping
    public ResponseMessage authenticateOauth2Account(@RequestBody AccountRequest accountRequest) {

        AccountPrincipal accountPrincipal = (AccountPrincipal) oAuth2Service.process(accountRequest);

        try {
            String email = accountPrincipal.getEmail();
            PreAuthenticatedAuthenticationToken authentication = new
                    PreAuthenticatedAuthenticationToken(accountPrincipal, null, accountPrincipal.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = tokenProvider.createToken(authentication);

            Map<Object, Object> model = new HashMap<>();
            model.put("email", email);
            model.put("token", token);
            return ResponseMessage.success(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password");
        }
    }
}
