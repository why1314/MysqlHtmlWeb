package com.itheima.web.servlet;

import com.itheima.entity.Contact;
import com.itheima.entity.PageBean;
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
 * @date 2019-03-27-15:13
 */
@WebServlet(name = "QueryByPageServlet", urlPatterns = "/queryByPage")
public class QueryByPageServlet extends HttpServlet {

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
        int pageSize = 5;
        PageBean<Contact> pageBean = service.queryByPage(curPage, pageSize);

        request.setAttribute("list", pageBean.getData());
        request.setAttribute("curPage", pageBean.getCurPage());
        request.setAttribute("totalPage", pageBean.getTotalPage());
        request.setAttribute("start", pageBean.getStart());
        request.setAttribute("end", pageBean.getEnd());
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

