package com.example.cw_spring.service.impl;

import com.example.cw_spring.dto.UserDTO;
import com.example.cw_spring.entity.UserEntity;
import com.example.cw_spring.repository.UserDAO;
import com.example.cw_spring.reqAndres.response.JwtAuthResponse;
import com.example.cw_spring.reqAndres.secure.SignIn;
import com.example.cw_spring.reqAndres.secure.SignUp;
import com.example.cw_spring.service.AuthenticationService;
import com.example.cw_spring.service.JwtService;
import com.example.cw_spring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {
    private final Mapping map;
    private final UserDAO userDAO;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword())
        );
        UserEntity user = userDAO.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder()
                .token(generateToken)
                .build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO userDTO = UserDTO.builder()
                .userId(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        UserEntity savedUser = userDAO.save(map.toUser(userDTO));
        String generateToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder()
                .token(generateToken)
                .build();
    }

    @Override
    public JwtAuthResponse refreshToken(String refreshToken) {
        var user = userDAO
                .findByEmail(jwtService.extractUsername(refreshToken))
                .orElseThrow(() -> new RuntimeException("User not found"));
        return JwtAuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();

    }
}
