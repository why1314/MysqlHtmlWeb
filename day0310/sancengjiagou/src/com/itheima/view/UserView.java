package com.itheima.view;

import com.itheima.service.UserService;

import java.util.Scanner;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-10-17:08
 */
public class UserView {
    public static void main(String[] args) {

        System.out.println("欢迎使用用户注册系统");

        while (true) {
            boolean flag = register();
            if (flag) {
                return;
            }
        }


    }

    private static boolean register() {
        System.out.println("请输入用户名");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
//          创建UserService对象
        UserService service = new UserService();
//          调用校验功能
        boolean flag = service.isRegister(username);
        if (flag) {
            System.out.println("该用户已经存在,请重新输入");
            return false;
        }

        System.out.println("请输入密码");
        String password = sc.nextLine();

        boolean f = service.register(username, password);

        if (f) {
            System.out.println("恭喜" + username + "注册成功");
            return true;
        } else {
            System.out.println("当前功能正在维护中");
            return true;
        }

    }

}
