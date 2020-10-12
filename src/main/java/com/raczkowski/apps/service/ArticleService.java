package com.raczkowski.apps.service;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.ArticleCreator;
import com.raczkowski.apps.model.repository.ArticlesDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
   ArticlesDao articlesDao;
   ArticleCreator articleCreator = new ArticleCreator();

    public ArticleService(ArticlesDao articlesDao) {
        this.articlesDao = articlesDao;
    }
    public List<Article> getAllArticles()
    {
        return articlesDao.loadArticles();
    }
    public Article getArticlesById(String id) { return articlesDao.loadArticleById(Integer.parseInt(id));}
    public void addArticle(String title, String content){articlesDao.addArticle(articleCreator.create(title,content));}
}
