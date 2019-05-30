package com.itheima.demo5;

import com.itheima.demo3.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 详情 SQL注入
 *
 * @author wz
 * @date 2019-03-07-16:44
 */
public class Demo {
    private static Connection conn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try {
            conn = JDBCUtils.getConection();
            conn.setAutoCommit(false);
            String sql = "select * from user where username='" + name + "'and password= '" + password + "';";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("登陆成功");
            }
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("登陆失败");
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
