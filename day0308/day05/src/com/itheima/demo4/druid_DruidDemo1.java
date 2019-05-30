package com.itheima.demo4;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-08-11:11
 */
public class druid_DruidDemo1 {

    public static void main(String[] args) throws Exception {
        //    导入jar包
//    导入druid的配置文件
//    使用druid的工厂创建连接池
        Properties pro = new Properties();
        InputStream is = druid_DruidDemo1.class.getResourceAsStream("druid.properties");
        pro.load(is);

//        根据配置文件创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        for (int i = 0; i < 9; i++) {
            System.out.println(dataSource.getConnection());
        }

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
