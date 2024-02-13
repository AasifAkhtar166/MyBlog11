package com.myblog.myblog11.payload;

import lombok.Data;

@Data
public class LoginDto {

    public String usernameOrEmail;
    private String password;
}
