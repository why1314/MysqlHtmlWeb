package com.itheima.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-07-10:53
 */
public class JDBCUtils {
    private static Connection conn;
    public static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try {

//              专门用于解析properties文件，框架底层大都是ResourceBundle,用ResourceBundle时 文件只能放在src下
//            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
//            String driver_class = bundle.getString("DRIVER_CLASS");

            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String driver = bundle.getString("JDBC.DRIVER");
            String url = bundle.getString("JDBC.URL");
            String user = bundle.getString("JDBC.USER");
            String password = bundle.getString("JDBC.PASSWORD");


//            解析配置文件
//            获取流文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
//            加载流文件对象
            pro.load(is);
//            获取相应的值
            DRIVER = pro.getProperty("JDBC.DRIVER");
            URL = pro.getProperty("JDBC.URL");
            USER = pro.getProperty("JDBC.USER");
            PASSWORD = pro.getProperty("JDBC.PASSWORD");

//          注册驱动
            Class.forName(driver);


            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConection() {

        return conn;
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }


}
