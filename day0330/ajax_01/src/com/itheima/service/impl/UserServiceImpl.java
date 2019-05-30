package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import com.itheima.service.UserService;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-02-17:05
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean isRegister(String username) {
        UserDao dao = new UserDao();
        User user = dao.isRegister(username);
        return user == null ? true : false;
    }
}
