package com.itheima.web.servlet;

import com.itheima.entity.Contact;
import com.itheima.service.ContactService;
import com.itheima.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-26-16:46
 */
@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            Map<String, String[]> map = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact, map);
            ContactService service = new ContactServiceImpl();
            int count = service.add(contact);
            HttpSession session = request.getSession();
            session.setAttribute("count", count);
            response.sendRedirect("/queryByPage");

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

