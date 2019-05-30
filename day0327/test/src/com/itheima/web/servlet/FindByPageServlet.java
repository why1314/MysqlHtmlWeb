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
 * @date 2019-03-27-11:54
 */
@WebServlet(name = "FindByPageServlet", urlPatterns = "/findByPage")
public class FindByPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        int curPage = 1;

        try {
            curPage = Integer.parseInt(request.getParameter("curPage"));
        } catch (Exception e) {
            curPage = 1;
        }
        ContactService service = new ContactServiceImpl();
        int pageSize = 3;
        List<Contact> list = service.findByPage(curPage, pageSize);

        request.setAttribute("list", list);
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

