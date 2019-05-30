package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-04-10:35
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User checkName(String username) {

        try {
            StringBuilder builder = new StringBuilder();
            builder.append("select * from tab_user where username like ?");
            User user = template.queryForObject(builder.toString(), new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public User login(String username, String md5pwd) {
        User user = null;
        try {
            String sql = "select * from tab_user where username=? and password=?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, md5pwd);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public int active(String code) {
        String sql = "UPDATE tab_user SET STATUS = ? WHERE CODE = ?";
        int count = template.update(sql, "Y", code);
        return count;
    }

    @Override
    public int register(User user) {
        String sql = "INSERT INTO tab_user VALUES(NULL,?,?,?,?,?,?,?,?,?) ";
        Object[] params = {
                user.getUsername(), user.getPassword(), user.getName(),
                user.getBirthday(), user.getSex(), user.getTelephone(),
                user.getEmail(), user.getStatus(), user.getCode()
        };
        int count = template.update(sql, params);
        return count;
    }
}
