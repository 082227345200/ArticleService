package com.raczkowski.apps.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Article {

    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    @JsonProperty("author")
    private String author;
    @JsonProperty("localDate")
    private LocalDate localDate;

    public Article(int id, String title, String content, String author, LocalDate localDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Article { " +
                "id = " + id +
                ", title = " + title +
                ", content = " + content +
                ", author = " + author +
                ", localDate = " + localDate +
                '}' + '\n';
    }

}
