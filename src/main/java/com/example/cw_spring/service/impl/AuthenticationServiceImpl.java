package com.example.cw_spring.service.impl;

import com.example.cw_spring.dto.EmployeeDTO;
import com.example.cw_spring.dto.UserDTO;
import com.example.cw_spring.entity.UserEntity;
import com.example.cw_spring.entity.enums.Role;
import com.example.cw_spring.repository.UserDAO;
import com.example.cw_spring.reqAndres.response.JwtAuthResponse;
import com.example.cw_spring.reqAndres.secure.SignIn;
import com.example.cw_spring.reqAndres.secure.SignUp;
import com.example.cw_spring.service.AuthenticationService;
import com.example.cw_spring.service.JwtService;
import com.example.cw_spring.util.Mapping;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;
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
    public JwtAuthResponse signUp(SignUp signUp, EmployeeDTO employeeDTO) {
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
    public JwtAuthResponse signUp() {
        Long rowCount = (Long) entityManager.createNativeQuery("SELECT COUNT(*) FROM users").getSingleResult();

        if (rowCount == null || rowCount == 0) {
            UserDTO userDTO = UserDTO.builder()
                    .userId(UUID.randomUUID().toString())
                    .email("sandaru@gmail.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.valueOf("ADMIN"))
                    .build();
            UserEntity savedUser = userDAO.save(map.toUser(userDTO));
            String generateToken = jwtService.generateToken(savedUser);
            return JwtAuthResponse.builder()
                    .token(generateToken)
                    .build();
        } else {
            return JwtAuthResponse.builder().token("User table is not empty").build();
        }
    }

    @Override
    public JwtAuthResponse refreshToken(String refreshToken) {
        String username = jwtService.extractUsername(refreshToken);
        UserEntity user = userDAO.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Email not found"));
        String generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder()
                .token(generateToken)
                .build();

    }
}
