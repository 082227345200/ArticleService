package com.raczkowski.apps.controller;

import com.raczkowski.apps.model.LogIn;
import com.raczkowski.apps.model.repository.UsersDao;

import com.raczkowski.apps.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping(value = "/api")
public class RootController extends HttpServlet {
    private final UsersDao usersDao;
    private final LogIn logIn;
    private final UserService userService;

    public RootController(UsersDao usersDao, LogIn logIn, UserService userService) {
        this.usersDao = usersDao;
        this.logIn = logIn;
        this.userService = userService;
    }

    //ToDo: 1. Registration service
    //      2. Updating user data in UserJDBCDao
    //      3. Add validations to loginService

    @GetMapping(value = "/login")
    ResponseEntity<?> Login(@RequestParam String email, String password) {
        if (logIn.logIn(usersDao, email, password) == null) {
            return new ResponseEntity<>("Email or password are wrong, try again", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(logIn.logIn(usersDao, email, password));
        }
    }

    @PatchMapping(value = "/update")
    ResponseEntity<?> updateUserData(@RequestParam String email, @RequestParam String password
            , @RequestParam String name, @RequestParam String surname) {
        userService.updateUserData(email, password, name, surname);
        return ResponseEntity.ok("User data updated");
    }
}
