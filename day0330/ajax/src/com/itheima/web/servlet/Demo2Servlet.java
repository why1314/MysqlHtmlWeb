package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-02-17:42
 */
@WebServlet(name = "Demo2Servlet", urlPatterns = "/demo2")
public class Demo2Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String keyWords = request.getParameter("keyWords");
        UserServiceImpl service = new UserServiceImpl();
        List<String> list = service.findkeyWords(keyWords);
        ObjectMapper om = new ObjectMapper();
        String listJson = om.writeValueAsString(list);
        response.getWriter().print(listJson);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

