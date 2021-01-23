package com.raczkowski.apps.service;

import com.raczkowski.apps.model.User;
import com.raczkowski.apps.model.repository.UsersDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersDao usersDao;

    public UserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void updateUserData(int id, String email, String password, String name, String lastName) {
        usersDao.updateUserData(id, email, password, name, lastName);
    }

    public List<User> loadUsers() {
        return usersDao.loadUsers();
    }
}
