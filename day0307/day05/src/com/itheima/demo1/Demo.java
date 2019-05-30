package com.itheima.demo1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-07-19:54
 */
public class Demo {
    public static void main(String[] args) throws SQLException {
//        方式一：使用默认配置（default-config）
//         new ComboPooledDataSource();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

//        方式二：使用命名配置<named-config name="itheimac3p0">

//        ComboPooledDataSource dataSource = new ComboPooledDataSource("itheimac3p0");

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();

        String sql = "select * from USER";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("username");
            String password = rs.getString("password");

            System.out.println(id+"  "+name+"  "+password);
        }

        conn.close();

    }
}