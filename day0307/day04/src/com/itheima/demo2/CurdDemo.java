package com.itheima.demo2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-07-10:20
 */
public class CurdDemo {

    @Test
    public void select() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/test";
        String USER = "root";
        String PASSWORD = "root";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        String sql = "select * from account";

        Statement stmt = conn.createStatement();
        ResultSet re = stmt.executeQuery(sql);
        while (re.next()) {

            int id = re.getInt("id");
            String name = re.getString("name");
            double money = re.getDouble("balance");

            System.out.println(id + "    " + name + "    " + money);

        }
        re.close();
        stmt.close();
        conn.close();

    }

    @Test
    public void add() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/test";
        String USER = "root";
        String PASSWORD = "root";

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement stmt = conn.createStatement();

        String sql="insert into account values(null,'王五',3000)";
        int i = stmt.executeUpdate(sql);
        System.out.println("影响的行数为"+i);

        stmt.close();
        conn.close();


    }

}
