package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentsController {
    private CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Comment>> getAllArticlesForArticle(@RequestParam int id) {
        return ResponseEntity.ok(commentsService.getAllCommentsForArticle(id));
    }

    @PostMapping(value = "/add")
    ResponseEntity<?> addNewComment(@RequestParam String content, @RequestParam int id) {
        commentsService.add(content, id);
        return ResponseEntity.ok("Added");
    }
}
