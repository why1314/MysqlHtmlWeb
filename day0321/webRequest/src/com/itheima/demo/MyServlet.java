package com.itheima.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-21-8:26
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//          解决中文乱码问题
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");


        String method = req.getMethod();
        System.out.println(method);
        String path = req.getContextPath();//
        System.out.println("当前项目名称"+path);
        String addr = req.getRemoteAddr();
        System.out.println("请求ip"+addr);
        int port = req.getLocalPort();
        System.out.println("请求端口"+port);
        String name = req.getParameter("userName");
        System.out.println(name);
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());

        System.out.println(req.getQueryString());

        System.out.println(req.getProtocol());

        Map<String, String[]> map = req.getParameterMap();

        Set<String> set = map.keySet();

        for (String s : set) {
            String[] strings = map.get(s);
            System.out.println(s);
            System.out.println(strings);
        }



//        String userAgent = req.getHeader("User-Agent");//获取User-Agent
//        String referer = req.getHeader("Referer");//获取Referer
//        System.out.println(userAgent);
//        System.out.println(referer);
//        Enumeration<String> names = req.getHeaderNames();
//        while (names.hasMoreElements()) {
//            String s = names.nextElement();
//            System.out.println(s);
//        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
