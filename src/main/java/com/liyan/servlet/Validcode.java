package com.liyan.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/validcode")
public class Validcode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片
        //单位：像素
        BufferedImage bufferedImage = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        //透明玻璃
        //向
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        //从哪个坐标开始填充，后两个参数，矩形区域
        graphics2D.fillRect(0, 0, 200, 100);
        //产生随机数
        List<Integer> randList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            randList.add(random.nextInt(10));
        }
        //设置字体
        graphics2D.setFont(new Font("宋体", Font.ITALIC | Font.BOLD, 50));
        Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.DARK_GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED};
        for (int i = 0; i < randList.size(); i++) {
            graphics2D.setColor(colors[random.nextInt(colors.length)]);
            graphics2D.drawString(randList.get(i) + "", i * 40, 70 + (random.nextInt(21) - 10));
        }
        for (int i=0;i<5;i++){
            graphics2D.setColor(colors[random.nextInt(colors.length)]);
            //划横线
            graphics2D.drawLine(0,random.nextInt(101),200,random.nextInt(101));
        }
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        ImageIO.write(bufferedImage, "jpg", servletOutputStream);
    }
}
