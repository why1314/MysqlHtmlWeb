package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-29-10:29
 */
@WebFilter(filterName = "LiveFilter",urlPatterns = "/live")
public class LiveFilter implements Filter {
    public void destroy() {
        System.out.println("LiveFilter的destroy方法执行了");

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiveFilter过滤到了请求");
        chain.doFilter(req, resp);
        System.out.println("LiveFilter过滤到了响应");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("LiveFilter的init方法执行了");
    }

}
