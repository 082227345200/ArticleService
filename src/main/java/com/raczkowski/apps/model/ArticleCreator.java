package com.raczkowski.apps.model;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ArticleCreator {
    public Article create(String title, String content, UserLoginData userLoginData) {
        String author = userLoginData.getName()
                + " " + userLoginData.getSurname();
        return new Article(0, title, content, author, LocalDate.now());
    }
}