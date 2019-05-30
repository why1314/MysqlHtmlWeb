package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.entity.Province;
import com.itheima.service.ProvinceService;
import com.itheima.service.impl.ProvinceServiceImpl;
import com.itheima.utils.BeanFactoryUtils;
import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

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
 * @date 2019-04-07-20:03
 */
@WebServlet(name = "ProvinceServlet", urlPatterns = "/province")
public class ProvinceServlet extends BaseServlet {


//   private ProvinceService service = (ProvinceService) BeanFactoryUtils.getBean("ProvinceService");

    public void findAllProvince(HttpServletRequest request, HttpServletResponse response) {
        try {
            ProvinceService service = new ProvinceServiceImpl();
            List<Province> provinceList = service.findAllProvince();
            Jedis jedis = JedisPoolUtils.getJedis();
            String list = jedis.get("provinceList");
            if (list.equals("null")){
                ObjectMapper om = new ObjectMapper();
                String jsonStr = om.writeValueAsString(provinceList);
                response.getWriter().print(jsonStr);
                jedis.set("provinceList",jsonStr);
            }else {
                response.getWriter().print(list);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

