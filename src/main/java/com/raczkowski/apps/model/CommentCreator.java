package com.raczkowski.apps.model;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommentCreator {

    private final UserLoginData userLoginData;

    public CommentCreator(UserLoginData userLoginData) {
        this.userLoginData = userLoginData;
    }

    public Comment create(String content) {
        String author = userLoginData.getName() + " " + userLoginData.getSurname();
        return new Comment(0, 0, content, author, LocalDate.now());
    }
}
