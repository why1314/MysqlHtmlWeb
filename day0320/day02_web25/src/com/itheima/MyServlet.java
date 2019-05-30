package com.itheima;

import javax.servlet.*;
import java.io.IOException;

/**
 * 详情 自定义servlet
 *
 * @author wz
 * @date 2019-03-20-11:55
 */
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     *功能详情：每次访问该servlet时，该方法都会执行
     *
     * @param:
     * @return
     * @author wz
     * @date 2019-3-20 11:57
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Aug三段式阿斯顿发");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
