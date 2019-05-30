package com.itheima.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-23-11:13
 */
@WebServlet(name = "GetRealPathServlet", urlPatterns = "/getRealPath")
public class GetRealPathServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");


        ServletContext context = getServletContext();
        String realPath = context.getRealPath("");
        String realPath1 = context.getRealPath("/");
        String realPath2 = context.getRealPath("/img/jinzita.jpg");

        System.out.println(realPath);
        System.out.println(realPath1);
        System.out.println(realPath2);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

