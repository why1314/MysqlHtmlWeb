package com.itheima.demo3;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 详情  使用配置文件
 *
 * @author wz
 * @date 2019-03-07-19:54
 */
public class c3p0Demo2 {

    public static void main(String[] args) throws  Exception {
//        1.导入c3p0的jar包
//        方式一：使用默认配置（default-config）
//         new ComboPooledDataSource();   链接池 创建c3p0连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        for (int i = 0; i < 10; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            if (i==9){
                connection.close();
            }
        }


//        方式二：使用命名配置<named-config name="itheimac3p0">

//        ComboPooledDataSource dataSource = new ComboPooledDataSource("itheimac3p0");

        Connection conn = dataSource.getConnection();
//        System.out.println(conn);
        String sql = "select * from USER";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("username");
            String password = rs.getString("password");

            System.out.println(id + "  " + name + "  " + password);
        }

        rs.close();
        stmt.close();
        conn.close();//归还链接到连接池

    }
}