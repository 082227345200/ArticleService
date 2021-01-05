package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.service.ArticleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController extends HttpServlet {
    private ArticleService articleService;

    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping(value = "/id", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Article> getAllArticlesById(@RequestParam String id) {
        return ResponseEntity.ok(articleService.getArticlesById(id));
    }

    @PostMapping(value = "/add")
    ResponseEntity<?> addNewArticle(@RequestParam String title, @RequestParam String content) {
        articleService.addArticle(title, content);
        return ResponseEntity.ok("saved");
    }

    @GetMapping(value = "/today")
    ResponseEntity<List<Article>> getArticleFromToday() {
        return ResponseEntity.ok(articleService.getArticleFromToday());
    }

    @GetMapping(value = "/newest")
    ResponseEntity<List<Article>> getNewestArticle() {
        return ResponseEntity.ok(articleService.getNewestArticle());
    }

    @GetMapping(value = "/{author}")
    ResponseEntity<?> getNewestArticle(@PathVariable String author) {
        if (articleService.getArticleOfAuthor(author).isEmpty()) {
            return new ResponseEntity<>("There are no articles for author:" + author, HttpStatus.OK);
        } else {
            return ResponseEntity.ok(articleService.getArticleOfAuthor(author));
        }
    }

    @GetMapping(value = "/sort")
    ResponseEntity<?> getSortedArticles(@RequestParam String choice) {
        if (articleService.sortArticles(choice) != null) {
            return ResponseEntity.ok(articleService.sortArticles(choice));
        } else {
            return new ResponseEntity<>("Illegal param: " + choice, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping(value = "/delete")
    ResponseEntity<?> removeArticle(@RequestParam int id) {
        if (articleService.getArticlesById(String.valueOf(id)) != null) {
            articleService.removeArticle(id);
            return ResponseEntity.ok("Removed");
        } else {
            return new ResponseEntity<>("Article with " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}