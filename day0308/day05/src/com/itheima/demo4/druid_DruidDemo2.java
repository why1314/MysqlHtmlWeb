package com.itheima.demo4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-08-11:11
 */
public class druid_DruidDemo2 {

    public static void main(String[] args) throws Exception {


        Connection conn = Druid_JDBCUtils.getConnection();
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
        Druid_JDBCUtils.close(rs, stmt, conn);

    }
}
