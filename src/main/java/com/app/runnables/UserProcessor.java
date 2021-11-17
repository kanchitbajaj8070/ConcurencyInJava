package com.app.runnables;

import com.app.beans.User;
import com.app.dao.UserDao;

import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {
    private User user;
    private UserDao userDao;

    public UserProcessor(User user, UserDao userDao) {
        this.user = user;
        this.userDao = userDao;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return userDao.saveUser(user);
    }
}
