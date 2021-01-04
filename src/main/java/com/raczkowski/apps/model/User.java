package com.raczkowski.apps.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("eMail")
    private String eMail;
    @JsonProperty("password")
    private String password;

    public User(int id, String name, String lastName, String eMail, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    String getMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Users { " +
                "id = " + id +
                ", name = " + name +
                ", lastName = " + lastName +
                ", e-Mail =" + eMail +
                ", password =" + password +
                '}' + '\n';
    }
}
