package com.pp1.easygreen.entity;

import lombok.Data;

@Data
public class BaseUser {
    private Long id;
    private String email;
    private String password;
    private String role;
    private String token;
    private String name;
    public BaseUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public BaseUser(String email) {
        this.email = email;

    }

    public BaseUser(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
