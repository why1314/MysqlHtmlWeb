package com.itheima.web.servlet;

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
 * @date 2019-03-27-9:44
 */
@WebServlet(name = "DeleteByIdServlet", urlPatterns = "/deleteById")
public class DeleteByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");


        String curPage = request.getParameter("curPage");
        String name = request.getParameter("uName");
        String qq = request.getParameter("qq");

        ContactService service = new ContactServiceImpl();
        int update = service.deleteById(id);

        request.setAttribute("curPage",curPage);
        request.setAttribute("name",name);
        request.setAttribute("qq",qq);
        request.getRequestDispatcher(request.getContextPath()+"/queryByConditions").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

