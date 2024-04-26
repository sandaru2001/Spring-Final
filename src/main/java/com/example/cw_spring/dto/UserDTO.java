package com.example.cw_spring.dto;

import com.example.cw_spring.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class UserDTO {

    private String userId;
    private String email;
    private String password;
    private Role role;
}
