package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-24-11:07
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Objects.equals("lastTime", cookie.getName())) {
                    c = cookie;
                    break;
                }
            }
        }


        if (c == null) {
            response.getWriter().print("您是第一次登陆");
        } else {
            String value = c.getValue();
            String decode = URLDecoder.decode(value, "utf-8");
            response.getWriter().print("您上次访问时间为：" + decode);

        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");

        String format = dateFormat.format(date);
        //        format有空格需要编码
        String dateStr = URLEncoder.encode(format, "utf-8");
        c = new Cookie("lastTime", dateStr);
        c.setMaxAge(60 * 60 * 24 * 30 * 12);
        c.setPath(request.getContextPath() + "/login");
        response.addCookie(c);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

