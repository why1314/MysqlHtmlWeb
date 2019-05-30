package com.itheima.dao;

import com.itheima.entity.Stu;
import com.itheima.utils.JDBCUtils;
import com.itheima.utils.OtOUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-21:38
 */
public class StuDao {
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Stu> findAll() {
        String sql = "select * from stu";
        List list = null;
        try {
            list = OtOUtils.queryByArgs(Stu.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public  List<Stu> stuDao(String vagName) {

        String sql= "select * from stu where name=?";

        List list = null;
        try {
             list = OtOUtils.queryByArgs(Stu.class, sql, vagName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
