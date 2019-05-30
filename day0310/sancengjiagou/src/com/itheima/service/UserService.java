package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-17:16
 */
public class UserService {

    private UserDao dao = new UserDao();

    public boolean isRegister(String username) {

        User user = dao.findByUserName(username);

//        false:用户不存在,
//        true :用户存在
        return user == null ? false : true;

    }

    public boolean register(String username, String password) {
//        调用dao层注册功能
        int count = dao.register(username, password);

//          true:注册成功
//          false：注册失败
        return count >= 1 ? true : false;
    }
}
