package com.itheima.view;

import com.itheima.entity.Stu;
import com.itheima.service.StuService;

import java.util.List;
import java.util.Scanner;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-20:09
 */
public class StuView {

    private static StuService stuService = new StuService();

    public static void main(String[] args) {

        System.out.println("欢迎使用学员管理系统");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=============================================================================");
            System.out.println("【请输入功能编号】");
            System.out.println("=============================================================================");
            System.out.println("【1.添加学员 2.修改学员 3.删除学员 4.按学号查询 5.查询所有 6.模糊查询 7.退出系统】");
            System.out.println("=============================================================================");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    System.out.println("请输入您要查询的名字");
                    String vagName = sc.next();

                    findByVag(vagName);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("您输入的编号不存在，请重新输入");
                    option = sc.nextInt();

            }
        }

    }

    private static void findByVag(String vagName) {

        System.out.println("您要查询的数据如下");

        List<Stu> stuList = stuService.findByVag(vagName);

        if (stuList.size() == 0) {
            System.out.println("【系统无数据】");
        } else {
            for (Stu stu : stuList) {
                System.out.println(stu.getId() + "  " + stu.getName() + "  " + stu.getSex() + "  " + stu.getAge());
            }

        }
    }


    /**
     * 功能详情： 查找所有学员
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-3-10 21:47
     */
    private static void findAll() {

        System.out.println("您要查询的数据如下");

        List<Stu> stuList = stuService.findAll();

        if (stuList.size() == 0) {
            System.out.println("【系统无数据】");
        } else {
            for (Stu stu : stuList) {
                System.out.println(stu.getId() + "  " + stu.getName() + "  " + stu.getSex() + "  " + stu.getAge());
            }

        }

    }


}
