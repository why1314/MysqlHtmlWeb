package com.itheima.demo3;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

/**
 * 详情   手动设置C3P0连接池参数
 *
 * @author wz
 * @date 2019-03-07-19:54
 */
public class c3p0Demo1 {

    public static void main(String[] args) throws  Exception {
//        1.导入c3p0的jar包
//         new ComboPooledDataSource();   链接池 创建c3p0连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

//       2.配置链接数据库的基本信息
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day04");
        dataSource.setUser("root");
        dataSource.setPassword("root");


//        连接池的参数信息
        dataSource.setInitialPoolSize(5);//设置连接池初始化链接数量
        dataSource.setMaxPoolSize(10);//设置连接池最大链接数量
        dataSource.setCheckoutTimeout(3000);//如果达到最大连接数，等待3秒，
        dataSource.setMaxIdleTime(1000);//最大空闲回收时间


        for (int i = 0; i < 9; i++) {
            System.out.println(dataSource.getConnection());
        }

        Connection conn = dataSource.getConnection();
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