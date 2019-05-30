package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.entity.City;
import com.itheima.entity.Province;
import com.itheima.service.CityService;
import com.itheima.service.ProvinceService;
import com.itheima.service.impl.CityServiceImpl;
import com.itheima.service.impl.ProvinceServiceImpl;

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
 * @date 2019-04-07-20:30
 */
@WebServlet(name = "CityServlet", urlPatterns = "/city")
public class CityServlet extends BaseServlet {

    public void findCityByPid(HttpServletRequest request, HttpServletResponse response) {
        try {
//      获取pid数据
            String pid = request.getParameter("pid");
            CityService service = new CityServiceImpl();
            List<City> cityList = null;
            if (pid != null && !"".equals(pid)) {
                cityList = service.findCityByPid(pid);
            }

            ObjectMapper om = new ObjectMapper();
            String jsonStr = om.writeValueAsString(cityList);
            response.getWriter().print(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

