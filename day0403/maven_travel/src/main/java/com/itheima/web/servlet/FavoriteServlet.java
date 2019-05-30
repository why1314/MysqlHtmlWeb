package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.entity.Favorite;
import com.itheima.entity.PageBean;
import com.itheima.entity.ResultInfo;
import com.itheima.entity.Route;
import com.itheima.entity.User;
import com.itheima.service.FavoriteService;
import com.itheima.utils.BeanFactoryUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-07-11:09
 */
@WebServlet(name = "FavoriteServlet", urlPatterns = "/favorite")
public class FavoriteServlet extends BaseServlet {

    private FavoriteService service = (FavoriteService) BeanFactoryUtils.getBean("FavoriteService");


    public void isFavorite(HttpServletRequest request, HttpServletResponse response) {
        try {
            String rid = request.getParameter("rid");
            boolean flag = false;
//       从session中 获取用户信息
            User user = (User) request.getSession().getAttribute("user");
//        判断是否登录
//        1 可以点击
//        0 不能点击
            if (user == null) {
                //          未登录 可以点击
                response.getWriter().print(1);
                return;
            } else {
                flag = service.isFavorite(rid, user.getUid());
                if (flag) {
                    //                已收藏不能点击
                    response.getWriter().print(0);
                } else {
                    //                未收藏，可以点击
                    response.getWriter().print(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加收藏
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void addMyFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultInfo info = null;
        try {
            //0.判断用户是否登录
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if(user==null){
                // 用户未登录
                info = new ResultInfo();
                info.setFlag(true);
                info.setData(0); // 未登录
            }else{
                //1.获取请求携带的rid的值
                String rid = request.getParameter("rid");
                //2.从session中获取uid的值
                int uid = user.getUid();
                //3.生成当前时间,封装到Favorite实体中
                Date date = new Date();
                Favorite fa = new Favorite();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                fa.setDate(format.format(date));
                fa.setRid(Integer.parseInt(rid));
                fa.setUid(uid);
                //4.调用service完成业务逻辑
                service.addMyFavorite(fa);
                //5.收藏成功
                info = new ResultInfo();
                info.setFlag(true);
                info.setData(1); // 收藏成功
            }
        } catch (Exception e) {
            e.printStackTrace();;
            info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("当前功能正在维护...");
        }
        ObjectMapper om = new ObjectMapper();
        String infoJson = om.writeValueAsString(info);
        response.getWriter().print(infoJson);
    }

    /**
     * 分页查询我的收藏
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void findMyFavoriteByPage(HttpServletRequest request, HttpServletResponse response) {
        try {

            int pageNumber = 1;
            try {
                pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }

            int pageSize = 4;

            User user = (User) request.getSession().getAttribute("user");

            PageBean<Favorite> pb = service.findMyFavoriteByPage(pageNumber, pageSize, user.getUid());

            request.setAttribute("pb", pb);
            request.getRequestDispatcher("/myfavorite.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 分页查询收藏排行榜
     * @param request
     * @param response
     */
    public void findRouteByRank(HttpServletRequest request, HttpServletResponse response) {
        try {

            int pageNumber = 1;
            try {
                pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }

            int pageSize = 8;


            PageBean<Route> pb = service.findRouteByRank(pageNumber, pageSize);

            request.setAttribute("pb", pb);
            request.getRequestDispatcher("/favoriterank.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

