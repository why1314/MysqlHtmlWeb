package com.itheima.dao;

import com.itheima.entity.User;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-17:20
 */
public class UserDao {
    //    设置JdbcTemplate全局变量
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User findByUserName(String username)  {
        try {
//        编写sql语句
            String sql = "select * from user where username = ?";
//        调用相关方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
//        返回对象
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public int register(String username, String password) {

//        编写sql语句
        String sql = "insert into user values(null,?,?)";

//        执行sql语句并返回结果到service层
        return template.update(sql, username, password);

    }
}
