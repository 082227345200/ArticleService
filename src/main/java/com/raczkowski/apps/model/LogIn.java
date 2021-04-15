package com.raczkowski.apps.model;

import com.raczkowski.apps.model.repository.UsersDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogIn {
    public UserLoginData logIn(UsersDao userRepository, String email, String password) {
        List<User> users = userRepository.loadUsers();
        for (User user : users) {
            if (email.equalsIgnoreCase(user.getMail())) {
                if (password.equals(user.getPassword())) {
                    return new UserLoginData(user.getName(), user.getLastName(), user.getMail(), user.getPassword());
                } else {
                    System.out.println("Something went wrong");
                }
            }
        }
        return null;
    }
}