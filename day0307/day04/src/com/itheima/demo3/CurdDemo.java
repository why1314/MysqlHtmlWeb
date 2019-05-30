package com.itheima.demo3;

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
    private Connection conn;

    @Test
    public void select() throws Exception {
        conn = JDBCUtils.getConection();

        String sql = "select * from USER ";

        Statement stmt = conn.createStatement();
        ResultSet re = stmt.executeQuery(sql);
        while (re.next()) {
            int id = re.getInt("id");
            String name = re.getString("username");
            String money = re.getString("password");

            System.out.println(id + "    " + name + "    " + money);

        }

        JDBCUtils.close(re, stmt, conn);

    }

    @Test
    public void add() throws Exception {
//        获得连接
        conn = JDBCUtils.getConection();
//          获得执行语句
        Statement stmt = conn.createStatement();
//            sql语句
        String sql = "insert into account values(null,'王五',3000)";
//        执行sql语句
        int i = stmt.executeUpdate(sql);
        System.out.println("影响的行数为" + i);

        stmt.close();
        conn.close();

        JDBCUtils.close(stmt, conn);
    }

}
