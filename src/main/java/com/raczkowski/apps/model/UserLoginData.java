package com.raczkowski.apps.model;

import org.springframework.stereotype.Repository;

@Repository
public class UserLoginData {
    private String email;
    private String password;
    private String name;
    private String surname;

    public UserLoginData() {
    }

    public UserLoginData(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
