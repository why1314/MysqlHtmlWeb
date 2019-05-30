package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-29-9:45
 */
@WebFilter(filterName = "Demo2Filter",urlPatterns = "/demo2")
public class Demo2Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //        过滤请求
        System.out.println("Demo2Filter过滤到了请求。。。");

//      放行代码 一这一行代码为分界线
        chain.doFilter(req, resp);

//        过滤响应
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
