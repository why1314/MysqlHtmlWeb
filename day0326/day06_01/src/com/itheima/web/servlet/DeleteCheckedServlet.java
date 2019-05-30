package com.itheima.web.servlet;

import com.itheima.service.ContactService;
import com.itheima.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-18:11
 */
@WebServlet(name = "DeleteCheckedServlet", urlPatterns = "/deleteChecked")
public class DeleteCheckedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        try {
//        获取要删除的联系人id
            String[] cids = request.getParameterValues("cid");

            if (cids==null) {
                response.sendRedirect(request.getContextPath() + "/findAll");
                return;
            }
//            调用service完成删除操作
            ContactService service = new ContactServiceImpl();
            service.deleteChecked(cids);

//            成功删除之后重定向到查询所有的servlet上

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

