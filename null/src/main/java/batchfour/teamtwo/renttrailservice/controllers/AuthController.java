package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.entities.AuthProvider;
import batchfour.teamtwo.renttrailservice.exceptions.BadRequestException;
import batchfour.teamtwo.renttrailservice.models.*;
import batchfour.teamtwo.renttrailservice.repositories.AccountRepository;
import batchfour.teamtwo.renttrailservice.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
    private AuthenticationManager authenticationManager;

   @Autowired
    private AccountRepository accountRepository;

   @Autowired
    private TokenProvider tokenProvider;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @PostMapping("/login")
    public ResponseMessage<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest) {

       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       loginRequest.getEmail(),
                       loginRequest.getPassword()
               )
       );

       SecurityContextHolder.getContext().setAuthentication(authentication);

       String token = tokenProvider.createToken(authentication);
       String email = loginRequest.getEmail();

       Map<Object, Object> data = new HashMap<>();
       data.put("email", email);
       data.put("token", token);

       return  ResponseMessage.success(data);
   }

    @PostMapping("/signup")
    public ResponseMessage<?> registerAccount(@Valid @RequestBody SignUpRequest signUpRequest) {
       if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
           throw new BadRequestException("Email address already in use.");
       }

       Account account = new Account();
       account.setName(signUpRequest.getName());
       account.setEmail(signUpRequest.getEmail());
       account.setPassword(signUpRequest.getPassword());
       account.setProvider(AuthProvider.local);

       account.setPassword(passwordEncoder.encode(account.getPassword()));

       Account result = accountRepository.save(account);

       return ResponseMessage.success(result);
    }
}
