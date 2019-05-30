package com.itheima.web.servlet;

import com.itheima.entity.Contact;
import com.itheima.service.ContactService;
import com.itheima.service.impl.ContactServiceImpl;

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
 * @date 2019-03-26-21:12
 */
@WebServlet(name = "QueryByConditionsServlet", urlPatterns = "/queryByConditions")
public class QueryByConditionsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uName");
        String qq = request.getParameter("qq");

        ContactService service = new ContactServiceImpl();
        List<Contact> list = service.queryByConditions(name, qq);
        request.setAttribute("list", list);

        request.setAttribute("name", name);
        request.setAttribute("qq", qq);
        request.getRequestDispatcher("/list.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

