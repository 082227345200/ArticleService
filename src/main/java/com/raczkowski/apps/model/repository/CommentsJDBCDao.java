package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.Article;
import com.raczkowski.apps.model.Comment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CommentsJDBCDao implements CommentsDao {
    @Override
    public void addComment(Comment comment, int idOdArticle) {
        Connection connection = connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comments(id, idofarticle, content, author, localdate) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, showComment().size());
            preparedStatement.setInt(2, idOdArticle);
            preparedStatement.setString(3, comment.getContent());
            preparedStatement.setString(4, comment.getAuthor());
            preparedStatement.setDate(5, Date.valueOf(comment.getLocalDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot insert Comment");
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> showComment() {

        Connection connection = connect();
        Statement statement;
        List<Comment> comments = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM comments");
            while (rs.next()) {
                int id = rs.getInt("id");
                int idOfArticle = rs.getInt("idofarticle");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Date localDate = rs.getDate("localdate");
                Comment comment = new Comment(id, idOfArticle, content, author, localDate.toLocalDate());
                comments.add(comment);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public List<Comment> commentsOfArticles(int idOfArticle) {
        Connection connection = connect();
        Statement statement;
        List<Comment> comments = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM comments WHERE idofarticle=" + idOfArticle);
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Date localDate = rs.getDate("localdate");
                Comment comment = new Comment(id, idOfArticle, content, author, localDate.toLocalDate());
                comments.add(comment);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/articleservice";
            String user = "postgres";
            String password = "Tajfun";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Comment DataBase.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
