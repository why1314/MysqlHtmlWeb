package com.itheima.demo;

import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-18-17:01
 */
public class Demo {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//
////        获取要添加的学生信息数据
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入学生姓名");
//        String name = sc.next();
//        System.out.println("请输入学生性别");
//        String sex = sc.next();
//        System.out.println("请输入学生年龄");
//        int age = sc.nextInt();
////         创建sql语句
//        String sql = "insert into student values(null,?,?,?)";
////        执行sql语句
//        template.update(sql, name, sex, age);

//        1.查询所有学生姓名,将查询结果打印到控制台
//        String sql="select * from student";
//        List<Student> studentList = template.query(sql, new BeanPropertyRowMapper<>(Student.class));
//        for (Student stu : studentList) {
//            System.out.println(stu.getId()+" : "+stu.getName()+" : "+stu.getSex()+" : "+stu.getAge());
//        }

//        2.查询id为1的学生信息,封装到Student实体中,并将信息打印到控制台
//
//        String sql = "select * from student WHERE id=?";
//
//        Student stu = template.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), 1);
//        System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getSex() + " : " + stu.getAge());
//         3.查询学生表中有多少学生,将结果打印到控制台

//        String sql="select count(*) from student";
//        Integer count = template.queryForObject(sql, int.class);
//        System.out.println(count);

//      4.根据id修改学生信息(将id为1的学生姓名改为"汤姆")
//        String sql = "update student set name=? where id=?";
//        template.update(sql,"汤姆",1);

//        5.根据id删除学生信息(删除id为1的学生)
        String sql = "DELETE FROM student where id=?";
        template.update(sql,1);


    }


}
