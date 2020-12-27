package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController extends HttpServlet {
    private final ArticleService articleService;
    private final Logger logger = LoggerFactory.getLogger(ArticlesController.class);

    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity <List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Article> getAllArticlesById(@PathVariable String id){
        return ResponseEntity.ok(articleService.getArticlesById(id));
    }

    @PostMapping(value = "/add")
    ResponseEntity<?> addNewArticle(@PathVariable("title") String title, @PathVariable("content") String content, HttpServletResponse response) throws IOException {
        articleService.addArticle(title, content);
        return ResponseEntity.ok("saved");
    }

    //Todo: Napisać nowa metodę do pobierania najnowszego artykułu, aktualnie metoda pobiera artyguły z localdate.now

    @GetMapping(value = "/newest")
    public List<Article> getNewestArticle() {
        return articleService.getNewestArticle();
    }

    @GetMapping(value = "/{author}")
    ResponseEntity<?> getNewestArticle(@PathVariable String author) {
        if (articleService.getArticleOfAuthor(author).isEmpty()) {
            return new ResponseEntity<>("There are no articles for author:" + author, HttpStatus.OK);
        } else {
            return ResponseEntity.ok(articleService.getArticleOfAuthor(author));
        }
    }

    @GetMapping(value = "/sort/{choice}")
    ResponseEntity<?> getSortedArticles(@PathVariable String choice) {
        if (articleService.sortArticles(choice) != null) {
            return ResponseEntity.ok(articleService.sortArticles(choice));
        } else {
            return new ResponseEntity<>("Illegal param: " + choice, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}