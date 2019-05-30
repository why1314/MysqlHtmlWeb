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

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-27-17:01
 */
@WebServlet(name = "FindByIdServlet", urlPatterns = "/findById")
public class FindByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String curPage = request.getParameter("curPage");
        String id = request.getParameter("id");
        ContactService service = new ContactServiceImpl();
        Contact contact = service.findById(id);
        request.setAttribute("curPage",curPage);
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

