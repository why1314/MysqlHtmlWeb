package com.itheima.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-07-10:02
 */
public class Demo {


    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
