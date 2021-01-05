package com.raczkowski.apps.service;

import com.raczkowski.apps.model.repository.UsersDao;

public class UserService {
    private final UsersDao usersDao;

    public UserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void updateUserData(String email, String password, String name, String surname) {
        usersDao.updateUserData(email, password, name, surname);
    }
}
