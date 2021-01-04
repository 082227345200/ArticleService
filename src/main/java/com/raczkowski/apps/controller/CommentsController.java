package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentsController {
    private  CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/all/{id}")
    ResponseEntity <List<Comment>> getAllArticlesForArticle(@PathVariable int id) {
        return ResponseEntity.ok(commentsService.getAllCommentsForArticle(id));
    }
}
