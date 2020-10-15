package com.raczkowski.apps.model;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommentCreator {
    UserLoginData userLoginData;

    public Comment create(String content, int idOfArticle) {
        String author = userLoginData.getName()
                + " " + userLoginData.getSurname();
        return new Comment(0, idOfArticle, content, author, LocalDate.now());
    }
}
