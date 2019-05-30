package com.itheima.web.servlet;

import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.BeanFactoryUtils;
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
 * @date 2019-04-04-9:51
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    //    线程是否安全，只要看多个线程访问同一资源时是否有共享数据（只读除外）有共享数据（不安全）
    //    private UserService service = new UserServiceImpl();
    private UserService service = (UserService) BeanFactoryUtils.getBean("UserService");;


    /**
     * 功能详情：
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-4 12:33
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能详情：用户登录
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-4 12:13
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User u = service.login(username, password);
            if (u == null) {
                //用户名或密码错误
                response.getWriter().print(2);
            } else {
                if ("N".equals(u.getStatus())) {
                    //未激活
                    response.getWriter().print(0);
                } else {
                    //已激活
                    request.getSession().setAttribute("user", u);
                    response.getWriter().print(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能详情：激活账号
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-4 11:29
     */
    public void active(HttpServletRequest request, HttpServletResponse response) {
//        获取参数
        try {
            String code = request.getParameter("code");

            boolean flag = service.active(code);
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/error/500.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能详情：注册用户
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-4 11:29
     */
    public void register(HttpServletRequest request, HttpServletResponse response) {

        try {
//            获取前端传递的数据
            Map<String, String[]> map = request.getParameterMap();
//              创建user对象
            User user = new User();
//              封装数据
            BeanUtils.populate(user, map);


//          调用service的register方法
            boolean flag = service.register(user);
            if (flag) {
                //注册成功
//                response.getWriter().print(1);
                response.sendRedirect(request.getContextPath() + "/register_ok.jsp");
            } else {
                //注册失败
                response.sendRedirect(request.getContextPath() + "/error/500.html");
//                response.getWriter().print(0);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能详情：注册用户名校验
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-6 8:33
     */
    public void checkName(HttpServletRequest request, HttpServletResponse response) {
        try {

            String username = request.getParameter("username");
//        校验该用户名是否已经存在
            boolean flag = service.checkName(username);
            if (flag) {
                response.getWriter().print("√");
            } else {
                response.getWriter().print("用户名已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

