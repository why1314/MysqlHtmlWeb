package com.itheima.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-29-9:45
 */
public class Demo3Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //        过滤请求
        System.out.println("Demo3Filter1过滤到了请求。。。");

//      放行代码 一这一行代码为分界线
        chain.doFilter(req, resp);

//        过滤响应
        System.out.println("Demo3Filter1过滤到了响应。。。");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
