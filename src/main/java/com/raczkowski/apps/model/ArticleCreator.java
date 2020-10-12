package com.raczkowski.apps.model;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ArticleCreator {
    UserLoginData userLoginData;

    public Article create(String title, String content) {
        String author = userLoginData.getName()
                + " " + userLoginData.getSurname();
        return new Article(0, title, content, author, LocalDate.now());
    }
}