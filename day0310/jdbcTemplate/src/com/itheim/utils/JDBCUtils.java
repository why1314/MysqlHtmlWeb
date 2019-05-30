package com.itheim.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 详情  工具类
 *
 * @author wz
 * @date 2019-03-09-18:13
 */
public class JDBCUtils {
    private static DataSource dataSource;
    private static Connection conn;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

//        根据配置文件创建连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    获取连接池
    public static Connection getConnection() throws SQLException {

        conn = dataSource.getConnection();
        return conn;
    }


    //    获取连接池
    public static DataSource getDataSource() {
        return dataSource;
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

    //    自定义框架
    public static  int update(String sql, Object[] params) throws SQLException {
//        获取连接
        conn = getConnection();
//      创建预编译对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ParameterMetaData pmetaData = pstmt.getParameterMetaData();
//        获取sql中？个数
        int count = pmetaData.getParameterCount();

        for (int i = 0; i < count; i++) {
            pstmt.setObject(i+1,params[i]);
        }

        int i = pstmt.executeUpdate();
        return i;
    }


}
