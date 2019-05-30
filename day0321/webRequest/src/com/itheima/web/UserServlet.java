package com.itheima.web;

import com.itheima.entity.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-21-14:57
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       解决中文乱码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        try {
//            获得前端页面传递过来的参数
            Map<String, String[]> map = request.getParameterMap();
//            将参数封装到user对象中
            User user = new User();
            BeanUtils.populate(user, map);
//            调用userService的login方法
            User u = userService.login(user);
            if (u != null) {
                System.out.println(u);
                response.getWriter().print("登陆成功");
            } else {
                response.getWriter().print("登陆失败");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            response.getWriter().print("当前功能正在维护...");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            response.getWriter().print("当前功能正在维护...");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

