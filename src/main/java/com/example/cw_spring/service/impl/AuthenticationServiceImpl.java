package com.example.cw_spring.service.impl;

import com.example.cw_spring.dto.EmployeeDTO;
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

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDAO userDAO;
    private final JwtService jwtService;
    private Mapping mapping;

    //Utils
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userDAO.findByEmail(signIn.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        var generateToken = jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(generateToken).build();

    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        return null;
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp, EmployeeDTO employeeDTO) {
        return null;
    }
}
