package com.mmz.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @Classname FileServlet
 * @Description TODO
 * @Date 2020/12/16 17:06
 * @Created by mmz
 */
/*实现文件的下载*/
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取下载文件的路径
        String realPath ="E:\\JavaOfKuang\\javaweb-01-servlet\\response-03\\src\\main\\resources\\touxiang.png";
        System.out.println("下载文件的路径是" + realPath);
        // 下载文件名是什么
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 设置想办法能让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename"+ URLEncoder.encode(fileName,"UTF-8"));
        // 获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        // 创建缓冲区
        int len = 0;
        byte[] bytes = new byte[1024];

        // 获取输出流的对象
        ServletOutputStream outputStream = resp.getOutputStream();
        // 将fileoutputStream放入到缓冲区,将outputStream写入到客户端
        while((len = fileInputStream.read()) != -1){
            outputStream.write(bytes,0,len);
        }

        // 把流关闭
        fileInputStream.close();
        outputStream.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
