package com.itheima.dao;

import com.itheima.entity.User;
import com.itheima.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-21-15:16
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User user) {
//        编写sql语句
        try {
            String sql = " select * from user where username=? and password=?";
//        执行sql语句
            User u = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUserName(), user.getPassword());

            return u;
        } catch (DataAccessException e) {
            return null;
        }

    }
}
