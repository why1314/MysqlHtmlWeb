package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-24-10:14
 */
@WebServlet(name = "SetMaxAgeServlet", urlPatterns = "/setMaxAge")
public class SetMaxAgeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");


        Cookie aCookie = new Cookie("ckey", "283");
        Cookie bCookie = new Cookie("dkey", "2323");

        aCookie.setPath(request.getContextPath()+"/aa");

        aCookie.setMaxAge(60 * 60);
        bCookie.setMaxAge(20);

        response.addCookie(aCookie);
        response.addCookie(bCookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

