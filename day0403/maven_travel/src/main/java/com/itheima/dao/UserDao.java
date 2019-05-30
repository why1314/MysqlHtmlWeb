package com.itheima.dao;

import com.itheima.entity.User; /**
 * 详情
 *
 * @author wz
 * @date 2019-04-04-10:34
 */
public interface UserDao {
    int register(User user);

    int active(String code);

    User login(String username, String md5pwd);

    User checkName(String username);
}
