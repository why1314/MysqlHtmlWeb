package com.itheima.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.itheima.entity.Category;
import com.itheima.entity.ResultInfo;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.utils.BeanFactoryUtils;

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
 * @date 2019-04-06-9:05
 */
@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = (CategoryService) BeanFactoryUtils.getBean("CategoryService");

    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

//            定义返回结果信息对象
        ResultInfo info = null;
        try {
//            返回结果统一设置
//            a、告诉浏览器执行是否成功
//            b、执行成功就展示信息
//            c、有异常就展示异常信息

//            查询所有的分类信息列表
            List<Category> categoryList = service.findAllCategory();
            info = new ResultInfo();
            info.setFlag(true);
            info.setData(categoryList);
        } catch (Exception e) {
            e.printStackTrace();
            info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("服务器忙。。。。");
        }

//
        ObjectMapper om = new ObjectMapper();
        String infoJson = om.writeValueAsString(info);
        response.getWriter().print(infoJson);


    }

}

