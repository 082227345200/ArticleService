package com.raczkowski.apps.model;


public class UserLoginData {
    private final String email;
    private final String password;
    private final String name;
    private final String surname;

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
