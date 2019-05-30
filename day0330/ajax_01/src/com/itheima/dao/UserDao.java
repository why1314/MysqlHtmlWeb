package com.itheima.dao;

import com.itheima.entity.User;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-02-17:06
 */
public class UserDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User isRegister(String username) {

        try {
            String sql = "select * from user where name=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }
}
