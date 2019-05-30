package com.itheim.jdbc_demo;


import com.itheim.entity.Product;
import com.itheim.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-09-18:13
 */
public class Demo {
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(" CREATE TABLE product( ")
                .append(" pid INT PRIMARY KEY AUTO_INCREMENT, ")
                .append(" pname VARCHAR(20) NOT NULL, ")
                .append(" price DOUBLE ")
                .append(" );");


        template.execute(builder.toString());
    }

    @Test
    public void add() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" insert into product values(null,?,?) ");
//        template.u
        int update = template.update(builder.toString(), "bdbbdsbn", 1212);
    }

    @Test
    public void delete() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" delete from product where pid=? ");

        template.update(builder.toString(), 3);
    }




    @Test
    /**
     *功能详情1： 查询单个结果的数据
     *
     * @param:
     * @return void
     * @author wz
     * @date 2019-3-10 10:02
     */
    public void queryForObject() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" select pname from product where pid=? ");

//        参数1：sql语句   参数2：返回值类型的字节码对象  参数3：可变参数
        System.out.println(template.queryForObject(builder.toString(), String.class, 1));
    }


    @Test
    /**
     *功能详情2：查询一条记录 select * from product where pid=?
     *
     * @param:
     * @return void
     * @author wz
     * @date 2019-3-10 10:09
     */
    public void queryForMap() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from product where pid=? ");

//        参数1：sql语句     参数3：可变参数
        Map<String, Object> map = template.queryForMap(builder.toString(), 1);
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator<Map.Entry<String, Object>> it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            System.out.println(next.getKey() + "   " + next.getValue());
        }

    }

    @Test
    /**
     *功能详情3：查询多条记录 select * from product
     *
     * @param:
     * @return void
     * @author wz
     * @date 2019-3-10 10:09
     */
    public void queryForList() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from product ");

//        参数1：sql语句
        List<Map<String, Object>> mapList = template.queryForList(builder.toString());
        for (Map<String, Object> map : mapList) {
            Set<Map.Entry<String, Object>> set = map.entrySet();
            Iterator<Map.Entry<String, Object>> it = set.iterator();

            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                System.out.println(next.getKey() + "   " + next.getValue());
            }
        }

    }


    @Test
    /**
     *功能详情4：查询多条记录 select * from product
     *
     * @param:
     * @return void
     * @author wz
     * @date 2019-3-10 10:09
     */
    public void query() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from product ");

//        参数1：sql语句
//        参数2：RowMapper 本条记录 自己手动封装
        List<Product> list = template.query(builder.toString(), new RowMapper<Product>() {
            //resultSet：被遍历到的本条记录
            //i：索引值
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });
    }


    @Test
    /**
     *功能详情5：查询多条记录 select * from product
     *
     * @param:
     * @return void
     * @author wz
     * @date 2019-3-10 10:09
     */
    public void query1() {
//        导入jar包
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from product ");

//        参数1：sql语句
//        参数2：BeanPropertyRowMapper 每条记录自动封装为Product对象
        List<Product> list = template.query(builder.toString(), new BeanPropertyRowMapper<Product>(Product.class));
//          遍历每个对象
        for (Product product : list) {
            System.out.println(product);
        }

    }

}
