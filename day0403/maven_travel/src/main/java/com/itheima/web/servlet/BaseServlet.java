package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-04-12:36
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String methodName = request.getParameter("method");

            Class clazz = this.getClass();

            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//            method.setAccessible(true);

            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

