package com.br.alura.forum.controller;

import com.br.alura.forum.security.AuthenticationService;
import com.br.alura.forum.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        if (authenticationService.authenticate(authRequest.getUsername(), authRequest.getPassword())) {
            return tokenProvider.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
