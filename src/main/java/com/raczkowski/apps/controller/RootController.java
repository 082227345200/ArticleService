package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.LogIn;
import com.raczkowski.apps.model.User;
import com.raczkowski.apps.model.repository.UsersDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/login")
public class RootController extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(ArticlesController.class);
    private static final String EMAIL_PARAM = "email";
    private static final String PASSWORD_PARAM = "password";
    UsersDao usersDao;

    public RootController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    LogIn logIn = new LogIn();

    //todo: Naprawić to bo źle działa

    @GetMapping(value = "/api")
    @ResponseBody
    ResponseEntity<?> Login(HttpServletRequest request) {
        String email = request.getParameter(EMAIL_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);
        if (logIn.logIn(usersDao, email, password) != null) {
            return new ResponseEntity<>("Email or password are wrong, try again", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(logIn.logIn(usersDao, email, password));
        }
    }
}
