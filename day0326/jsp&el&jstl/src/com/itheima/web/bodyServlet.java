package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-23-10:23
 */
@WebServlet(name = "bodyServlet", urlPatterns = "/body")
public class bodyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
//        ServletOutputStream outputStream = response.getOutputStream();
        PrintWriter writer = response.getWriter();
        writer.print("<table border='1px'>");
        writer.print("<tr>");
        writer.print("<td>1</td>");
        writer.print("<td>就哀伤的歌</td>");
        writer.print("</tr>");
        writer.print("</table>");


        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

