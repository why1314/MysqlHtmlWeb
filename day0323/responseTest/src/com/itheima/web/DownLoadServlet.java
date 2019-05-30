package com.itheima.web;

import com.itheima.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 详情
 *
 * @author wz
 * @date 2019-03-23-11:20
 */
@WebServlet(name = "DownLoadServlet", urlPatterns = "/downLoad")
public class DownLoadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

//        获取参数名
        String fileName = request.getParameter("fileName");

//        设置两个头
        ServletContext context = getServletContext();
//        获取被下载文件的mime类型 然后设置content-type
        String mimeType = context.getMimeType(fileName);
        response.setContentType(mimeType);
//        response.setHeader("content-type",mimeType);

//      获取用户代理
        String agent = request.getHeader("User-Agent");
        String name = DownLoadUtils.getName(agent, fileName);
//        设置下载专用头
        response.setHeader("Content-Disposition", "attachment;filename=" + name);

//      获取文件输出流
//        先读取文件
        String realPath = context.getRealPath("/download/" + fileName);
        FileInputStream is = new FileInputStream(realPath);
        ServletOutputStream os = response.getOutputStream();

        int len = 0;
        byte[] bytes = new byte[1024];

        while ((len = is.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }

        is.close();
        os.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

