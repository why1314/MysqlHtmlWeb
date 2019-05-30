package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-24-10:03
 */
@WebServlet(name = "CreateCookieServlet", urlPatterns = "/createCookie")
public class CreateCookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        Cookie aCookie = new Cookie("akey","47");
        Cookie bCookie = new Cookie("bkey","bvalue");


        aCookie.setPath(request.getContextPath());
//        返回给浏览器进行保存
        response.addCookie(aCookie);
        response.addCookie(bCookie);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

