package com.mmz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @Classname PropertiesServlet
 * @Description TODO
 * @Date 2020/12/16 16:01
 * @Created by mmz
 */
public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream inputStream =  this.getServletContext().getResourceAsStream("/WEB-INF/classes/user.properties");

        Properties properties = new Properties();
        properties.load(inputStream);
        String name = properties.getProperty("name");
        String pwd = properties.getProperty("pwd");
        PrintWriter writer = resp.getWriter();
        writer.println(name + " "+pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
