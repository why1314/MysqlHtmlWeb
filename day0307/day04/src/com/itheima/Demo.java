package com.itheima;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-07-9:24
 */
public class Demo {

//    jdbc 协议
//     localhost  mysql数据库地址

    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "root";


    public static void main(String[] args) throws Exception {
//        注册驱动
//        将mysql的驱动类加载到内存中
        DriverManager.registerDriver(new Driver());

//        建立连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        String sql = "select * from account";

        Statement stmt = conn.createStatement();
        ResultSet set = stmt.executeQuery(sql);
        while (set.next()) {
            int id = set.getInt("id");
            String name = set.getString("name");
            double money = set.getDouble("balance");

            System.out.println(id + "    " + name + "    " + money);

        }

        set.close();
        stmt.close();
        conn.close();

    }
}
