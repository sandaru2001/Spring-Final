package com.example.cw_spring.reqAndres.secure;

import com.example.cw_spring.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SignUp {
    private String email;
    private String password;
    private Role role;
}
