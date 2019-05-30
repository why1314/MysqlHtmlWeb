package com.itheima.demo;

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
 * @date 2019-03-21-11:08
 */
@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        解决中文乱码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        response.sendRedirect("");
        response.setHeader("refresh","avds");
        String referer = request.getHeader("Referer");

        
        response.setContentType("text/html;charset=utf-8");
        if (referer != null && referer.equals("http://localhost:8080/web/download.html")) {
            System.out.println("允许下载");
            response.getWriter().print("哀伤的歌 true");
        } else {
            System.out.println("不允许下载");
            response.getWriter().print("哀伤的歌 false");
        }
    }
}
