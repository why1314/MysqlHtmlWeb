package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactoryUtils;
import com.itheima.utils.MD5Utils;
import com.itheima.utils.MailUtils;
import com.itheima.utils.UUIDUtils;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-04-9:54
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = (UserDao) BeanFactoryUtils.getBean("UserDao");

    @Override
    public boolean register(User user) throws Exception {

//        对密码进行加密
        String password = MD5Utils.encodeByMd5(user.getPassword());

        user.setPassword(password);

        String code = UUIDUtils.getUuid();

        String toEmail = user.getEmail();
        String mailMsg = "<a href='http://localhost:8080/travel/user?method=active&code=" + code + "'>点我激活</a>";
        MailUtils.sendMail(toEmail, mailMsg);


        user.setCode(code);
        user.setStatus("N");

        int count = dao.register(user);

        return count > 0 ? true : false;
    }

    @Override
    public boolean checkName(String username) {
        User u = dao.checkName(username);
        return u == null ? true : false;
    }

    @Override
    public User login(String username, String password) throws Exception {
        String md5pwd = MD5Utils.encodeByMd5(password);
        return dao.login(username, md5pwd);

    }

    @Override
    public boolean active(String code) {
        int count;
        try {
            count = dao.active(code);
        } finally {

        }
        return count > 0 ? true : false;
    }
}
