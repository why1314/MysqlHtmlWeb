package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-21-15:13
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User user) {
        return userDao.login(user);

    }
}
