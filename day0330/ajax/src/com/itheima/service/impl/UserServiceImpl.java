package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import com.itheima.service.UserService;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-02-17:05
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDao();

    @Override
    public boolean isRegister(String username) {
        User user = dao.isRegister(username);
        return user == null ? true : false;
    }

    @Override
    public List<String> findkeyWords(String keyWords) {
        List<String> list = dao.findkeyWords(keyWords);
        return list;
    }
}
