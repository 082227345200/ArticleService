package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ArticlesDao {

    void addArticle(Article article);

    void addArticles(ArrayList<Article> articles);

    List<Article> loadArticles();

    Article loadArticleById(int id);

    void removeArticle(int id);
}
