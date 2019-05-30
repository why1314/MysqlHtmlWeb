package com.itheima.web;

import javax.servlet.ServletConfig;
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
 * @date 2019-03-23-10:50
 */
@WebServlet(name = "GetMimeServlet", urlPatterns = "/getMime")
public class GetMimeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        System.out.println(request.getContextPath());

        ServletConfig config = getServletConfig();
//        ServletContext context = config.getServletContext();
        ServletContext context = this.getServletContext();
//        ServletContext servletContext = getServletContext();
        String fileName=request.getParameter("fileName");
        System.out.println(context.getMimeType(fileName));
        response.getWriter().print(fileName);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

