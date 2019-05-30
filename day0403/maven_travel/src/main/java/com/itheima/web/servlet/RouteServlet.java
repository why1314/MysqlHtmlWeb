package com.itheima.web.servlet;

import com.itheima.entity.PageBean;
import com.itheima.entity.Route;
import com.itheima.service.RouteService;
import com.itheima.service.impl.RouteServiceImpl;
import com.itheima.utils.BeanFactoryUtils;

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
 * @date 2019-04-06-10:07
 */
@WebServlet(name = "RouteServlet", urlPatterns = "/route")
public class RouteServlet extends BaseServlet {

    private RouteService service = (RouteService) BeanFactoryUtils.getBean("RouteService");

    /**
     * 功能详情：分页查询分类下的线路信息
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-6 10:23
     */
    public void findRouteByPage(HttpServletRequest request, HttpServletResponse response) {
        try {
//        获取请求携带的pageNumber值
            int pageNumber = 1;
            try {
                pageNumber = Integer.parseInt(request.getParameter("PageNumber"));
            } catch (Exception e) {
                pageNumber = 1;
            }
//      自定义pagesize的值
            int pageSize = 10;
//        获取cid的值
            String cid = request.getParameter("cid");
//            获取rname的值
            String rname = request.getParameter("rname");
//          调用service处理业务逻辑
            PageBean<Route> pb = service.findRouteByPage(pageNumber, pageSize, cid, rname);
//            请求转发到route_list.jsp页面
            request.setAttribute("pb", pb);
            request.setAttribute("rname", rname);
            request.setAttribute("cid", cid);
            request.getRequestDispatcher("/route_list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能详情：根据线路id查询该线路信息
     *
     * @return
     * @param:
     * @author wz
     * @date 2019-4-6 22:46
     */
    public void findRouteByRid(HttpServletRequest request, HttpServletResponse response) {
        try {
//            获取线路rid的值
            String rid = request.getParameter("rid");
//            调用service处理业务逻辑
            Route route = service.findRouteByRid(rid);
            request.setAttribute("route", route);
            request.getRequestDispatcher("/route_detail.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

