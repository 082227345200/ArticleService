package com.raczkowski.apps.service;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.ArticleCreator;
import com.raczkowski.apps.model.ArticleStatistics;
import com.raczkowski.apps.model.repository.ArticlesDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private ArticlesDao articlesDao;
    private ArticleCreator articleCreator = new ArticleCreator();
    private ArticleStatistics articleStatistics = new ArticleStatistics();


    public ArticleService(ArticlesDao articlesDao) {
        this.articlesDao = articlesDao;
    }

    public List<Article> getAllArticles() {
        return articlesDao.loadArticles();
    }

    public Article getArticlesById(String id) {
        return articlesDao.loadArticleById(Integer.parseInt(id));
    }

    public void addArticle(String title, String content) {
        articlesDao.addArticle(articleCreator.create(title, content));
    }

    public List<Article> getNewestArticle() {
        return articleStatistics.getNewestArticle();
    }

    public List<Article> getArticleFromToday() {
        return articleStatistics.articlesFromToday();
    }

    public List<Article> getArticleOfAuthor(String author) {
        return articleStatistics.articlesOfAuthor(author);
    }

    public List<Article> sortArticles(String choice) {
        return articleStatistics.articlesFilter(choice);
    }
}
