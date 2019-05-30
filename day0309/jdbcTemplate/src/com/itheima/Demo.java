package com.itheima;

import com.itheima.Util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-09-18:13
 */
public class Demo {
    public static void main(String[] args) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(" CREATE TABLE product( ")
                .append(" pid INT PRIMARY KEY AUTO_INCREMENT, ")
                .append(" pname VARCHAR(20) NOT NULL, ")
                .append(" price DOUBLE ")
                .append(" );");

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        template.execute(builder.toString());
    }


}
