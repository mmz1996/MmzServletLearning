package com.mmz.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Classname ImageServlet
 * @Description TODO
 * @Date 2020/12/16 17:29
 * @Created by mmz
 */
/*实现动态的验证码*/
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果让浏览器刷新一次
        resp.setHeader("refresh","3");

        // 在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

        // 得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics(); // 笔

        // 设置图片的背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);

        //给图片写数据
        graphics.setColor(Color.blue);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNum(),0,20);
        System.out.println(makeNum());

        // 告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");

        // 网站存在缓存，不让浏览器设置缓存
        resp.setDateHeader("expires",-1);

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        // 把图片给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(99999999)+"";
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i <7 - num.length();++i){
            stringBuffer.append("0");
        }
        num = stringBuffer.toString()+num;
        return num;
    }
}
