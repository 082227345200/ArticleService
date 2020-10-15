package com.raczkowski.apps.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Comment {
    @JsonProperty("id")
    private final int id;
    @JsonProperty("idOfArticle")
    private final int idOfArticle;
    @JsonProperty("content")
    private final String content;
    @JsonProperty("author")
    private final String author;
    @JsonProperty("localDate")
    private final LocalDate localDate;

    public Comment(int id, int idOfArticle, String content, String author, LocalDate localDate) {
        this.id = id;
        this.idOfArticle = idOfArticle;
        this.content = content;
        this.author = author;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public int getIdOfArticle() {
        return idOfArticle;
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
        return "Comment{ " +
                " id =" + id +
                ", idOfArticle = " + idOfArticle +
                ", content = " + content +
                ", author = " + author +
                ", localDate = " + localDate +
                '}'+'\n';
    }
}
