package com.matheuslincon.employercreatorspring.services;

import com.matheuslincon.employercreatorspring.data.dto.security.AccountCredentialsDTO;
import com.matheuslincon.employercreatorspring.data.dto.security.TokenDTO;
import com.matheuslincon.employercreatorspring.model.User;
import com.matheuslincon.employercreatorspring.repositories.UserRepository;
import com.matheuslincon.employercreatorspring.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    @SuppressWarnings("rawtypes")
    public ResponseEntity signin(AccountCredentialsDTO data) {
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = repository.findByUsername(username);

            var tokenResponse = new TokenDTO();

            if (user != null) {
                tokenResponse = tokenProvider.createAccessToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }
            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity refreshToken(String username, String refreshToken) {
        User user = repository.findByUsername(username);

        var tokenResponse = new TokenDTO();

        if (user != null) {
            tokenResponse = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
        return ResponseEntity.ok(tokenResponse);
    }
}
