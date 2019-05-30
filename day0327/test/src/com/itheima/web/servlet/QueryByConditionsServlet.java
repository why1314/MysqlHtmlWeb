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
//        当前页页码
        int curPage = 1;
        try {
            curPage = Integer.parseInt(request.getParameter("curPage"));
        } catch (Exception e) {
            curPage = 1;
        }

//        每页显示条数
        int pageSize = 5;

        String name = request.getParameter("uName");
        String qq = request.getParameter("qq");

        System.out.println(name);
        ContactService service = new ContactServiceImpl();
        PageBean<Contact> pageBean = service.queryByConditions(name, qq, curPage, pageSize);

        request.setAttribute("list", pageBean.getData());
        request.setAttribute("curPage", pageBean.getCurPage());
        request.setAttribute("totalPage", pageBean.getTotalPage());
        request.setAttribute("start", pageBean.getStart());
        request.setAttribute("end", pageBean.getEnd());

//        用于回显
        request.setAttribute("name", name);
        request.setAttribute("qq", qq);

        request.getRequestDispatcher("/list1.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

