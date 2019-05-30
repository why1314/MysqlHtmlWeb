package com.itheima.web.servlet;

import com.itheima.entity.Contact;
import com.itheima.service.ContactService;
import com.itheima.service.impl.ContactServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-27-16:51
 */
@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        try {
            String curPage = request.getParameter("curPage");
            Map<String, String[]> map = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact, map);
            ContactService service = new ContactServiceImpl();
            service.update(contact);
            request.getRequestDispatcher(request.getContextPath() + "/queryByPage?curPage=" + curPage).forward(request, response);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

