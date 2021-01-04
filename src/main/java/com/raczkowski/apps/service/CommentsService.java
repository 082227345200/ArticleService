package com.raczkowski.apps.service;

import com.raczkowski.apps.model.Comment;
import com.raczkowski.apps.model.repository.CommentsDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsService {
    private final CommentsDao commentsDao;

    public CommentsService(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }

    public List<Comment> getAllCommentsForArticle(int id){
        return commentsDao.commentsOfArticles(id);
    }
}
