package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-29-11:52
 */
@WebFilter(filterName = "TextFilter",urlPatterns = "/text",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class TextFilter implements Filter {

    private List<String> list = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {

//        解析敏感词汇文件，并放到集合中
        try {
            InputStream stream = TextFilter.class.getClassLoader().getResourceAsStream("word.txt");
            InputStreamReader is = new InputStreamReader(stream,"utf-8");

            BufferedReader reader = new BufferedReader(is);
            String str = null;
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
            reader.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        过滤请求
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String msg = request.getParameter("msg");
        for (String str : list) {
            if (msg != null && !"".equals(msg)) {
                if (msg.contains(str)) {
                    request.setAttribute("str",str);
                    request.setAttribute("errMsg", "您的评论中有敏感词汇。。。");
                    request.getRequestDispatcher(request.getContextPath()+"/text.jsp").forward(request, response);
                    return;
                }
            } else {
                request.setAttribute("errMsg", "评论信息不能为空。。。。");
                request.getRequestDispatcher(request.getContextPath()+"/text.jsp").forward(request, response);
                return;
            }
        }

        chain.doFilter(req, resp);
//        过滤相应
    }

    public void destroy() {

    }


}
