package com.mmz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname RequestTest
 * @Description TODO
 * @Date 2020/12/16 20:24
 * @Created by mmz
 */
public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入这个请求了");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + password);

        // 重定向，一定要注意路径问题
        resp.sendRedirect("/r/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
