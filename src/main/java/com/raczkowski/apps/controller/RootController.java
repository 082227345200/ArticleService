package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.LogIn;
import com.raczkowski.apps.model.repository.UsersDao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class RootController extends HttpServlet {
    private static final String EMAIL_PARAM = "email";
    private static final String PASSWORD_PARAM = "password";
    private final UsersDao usersDao;
    private final LogIn logIn;

    public RootController(UsersDao usersDao, LogIn logIn) {
        this.usersDao = usersDao;
        this.logIn = logIn;
    }


    @GetMapping(value = "/login")
    ResponseEntity<?> Login(HttpServletRequest request) {
        String email = request.getParameter(EMAIL_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);
        if (logIn.logIn(usersDao, email, password) == null) {
            return new ResponseEntity<>("Email or password are wrong, try again", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(logIn.logIn(usersDao, email, password));
        }
    }
}
