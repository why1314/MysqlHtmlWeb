package com.itheima.service;

import com.itheima.entity.User; /**
 * 详情
 *
 * @author wz
 * @date 2019-04-04-9:53
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     * @throws Exception
     */
    boolean register(User user) throws Exception;

    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     *用户登陆
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User login(String username, String password) throws Exception;

    /**
     * 注册用户名校验
     * @param username
     * @return
     */
    boolean checkName(String username);
}
