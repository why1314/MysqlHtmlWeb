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
 * @date 2019-03-24-10:24
 */
@WebServlet(name = "DefaultPathServlet", urlPatterns = "/defaultPath")
public class DefaultPathServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        Cookie aa = new Cookie("akey", "evalue");
        Cookie bb = new Cookie("bkey", "fvalue");

        aa.setPath(request.getContextPath());
        response.addCookie(aa);
        response.addCookie(bb);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

