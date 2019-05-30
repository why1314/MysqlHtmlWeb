package com.itheima.web;

import com.itheima.entity.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

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
//            获取session中的验证码
            HttpSession session = request.getSession();
            String scode = (String) session.getAttribute("scode");
//            session中取出验证码后删除
            session.removeAttribute("scode");
//            获取参数
            String ucode = request.getParameter("ucode");

//            校验
            if (ucode == null || ucode.equals("")) {
                response.getWriter().print("验证码不能为空");
                return;
            }

            if (!ucode.equalsIgnoreCase(scode)) {
                response.getWriter().print("验证码输入有误");
                return;
            }


//            获得前端页面传递过来的参数
            Map<String, String[]> map = request.getParameterMap();
//            将参数封装到user对象中
            User user = new User();
            BeanUtils.populate(user, map);
//            调用userService的login方法
            User u = userService.login(user);
            if (u != null) {
                response.getWriter().print("登陆成功");
//                System.out.println(request.getParameter("rember"));
                boolean flag = request.getParameter("rember") != null ? true : false;
                Cookie userName = null;
                if (flag) {
                    String uName = URLEncoder.encode(u.getUserName(), "UTF-8");
                    userName = new Cookie("userName", uName);
                    userName.setMaxAge(24 * 60 * 60);

                } else {
                    userName = new Cookie("userName", "");
                    userName.setMaxAge(24 * 60 * 60);
                }
                userName.setPath(request.getContextPath());
                response.addCookie(userName);

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

