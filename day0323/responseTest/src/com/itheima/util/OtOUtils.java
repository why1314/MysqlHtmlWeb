package com.itheima.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-18:00
 */
public class OtOUtils {
    private static Connection conn;

    static {
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> queryByArgs(Class<T> clazz, String sql, Object... args) throws Exception {

        try {
//            获取连接

//             获取预编译对象
            PreparedStatement pstmt = conn.prepareStatement(sql);
//             获取参数元数据
            ParameterMetaData pstmtMetaData = pstmt.getParameterMetaData();
//            获取参数个数
            int count = pstmtMetaData.getParameterCount();
//            遍历参数数组并赋值
            for (int i = 0; i < count; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
//            执行sql语句，获得结果集
            ResultSet rs = pstmt.executeQuery();

//            获得结果集元数据
            ResultSetMetaData rsMetaData = rs.getMetaData();
//          根据结果集元数据获得返回字段的个数
            int columnCount = rsMetaData.getColumnCount();


            List<T> list = new ArrayList<>();
            while (rs.next()) {
//                通过反射创建对象
                Object o = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
//                    获取字段的名称
                    String columnName = rsMetaData.getColumnName(i + 1);
//                  获得字段对象
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(o, rs.getObject(i + 1));

                }
                list.add((T) o);

            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }


    //    自定义框架
    public static int update(String sql, Object[] params) throws SQLException {

//      创建预编译对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ParameterMetaData pmetaData = pstmt.getParameterMetaData();
//        获取sql中？个数
        int count = pmetaData.getParameterCount();

        for (int i = 0; i < count; i++) {
            pstmt.setObject(i + 1, params[i]);
        }

        int i = pstmt.executeUpdate();
        return i;
    }

}
