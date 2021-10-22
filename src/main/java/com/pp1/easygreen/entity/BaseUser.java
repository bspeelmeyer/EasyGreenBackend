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

    // Constructors
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

    // Getters
    public String getPassword(){
        return password;
    }

    public Long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getRole(){
        return role;
    }

    public String getToken(){
        return token;
    }

    public String getName(){
        return name;
    }

    // setters

    public void setId(Long id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
