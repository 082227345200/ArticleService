package com.raczkowski.apps.service;

import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.model.CommentCreator;
import com.raczkowski.apps.model.repository.CommentsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    private final CommentsDao commentsDao;
    private final CommentCreator commentCreator;

    public CommentsService(CommentsDao commentsDao, CommentCreator commentCreator) {
        this.commentsDao = commentsDao;
        this.commentCreator = commentCreator;
    }

    public List<Comment> getAllCommentsForArticle(int id) {
        return commentsDao.commentsOfArticles(id);
    }

    public void add(String content, int id) {
        commentsDao.addComment(commentCreator.create(content), id);
    }
}
