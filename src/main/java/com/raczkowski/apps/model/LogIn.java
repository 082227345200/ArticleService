package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogIn {
    public UserLoginData logIn(UsersDao userRepository, String email, String password) {
        List<User> users = userRepository.loadUsers();

        User loggedInUser;
        for (User user : users) {
            if (email.equalsIgnoreCase(user.getMail())) {
                if (password.equals(user.getPassword())) {
                    loggedInUser = user;
                    return new UserLoginData(loggedInUser.getName(), loggedInUser.getLastName(), loggedInUser.getMail(), loggedInUser.getPassword());
                } else {
                    System.out.println("Something went wrong");
                }
            }
        }
        return null;
    }
}