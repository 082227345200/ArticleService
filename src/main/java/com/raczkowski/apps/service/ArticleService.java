package com.raczkowski.apps.service;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.ArticleCreator;
import com.raczkowski.apps.model.ArticleStatistics;
import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.model.repository.ArticlesDao;
import com.raczkowski.apps.model.repository.CommentsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    ArticlesDao articlesDao;
    CommentsDao commentsDao;
    ArticleCreator articleCreator = new ArticleCreator();
    ArticleStatistics articleStatistics = new ArticleStatistics();


    public ArticleService(ArticlesDao articlesDao, CommentsDao commentsDao) {
        this.articlesDao = articlesDao;
        this.commentsDao = commentsDao;
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
        return articleStatistics.articlesFromToday();
    }

    public List<Article> getArticleOfAuthor(String author) {
        return articleStatistics.articlesOfAuthor(author);
    }

    public List<Article> sortArticles(String choice) {
        return articleStatistics.articlesFilter(choice);
    }

    public List<Comment> getCommentsOfArticle(int idOfArticle) {
        return commentsDao.commentsOfArticles(idOfArticle);
    }
}
