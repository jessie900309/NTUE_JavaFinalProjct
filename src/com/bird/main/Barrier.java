package com.bird.main;

import com.bird.util.Constant;
import com.bird.util.GameUtil;
import java.util.Random;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Barrier {
    private static BufferedImage[] imgs;
    static {
        final int COUNT = 6;
        imgs = new BufferedImage[COUNT];
        for(int i = 0;i < COUNT;i++){
            imgs[i] = GameUtil.loadBufferedImage(Constant.BARRIER_IMG_PATH[i]);
        }
    }

    //移動速度
    public static final int MIN_SPEED = 1;
    public static final int MAX_SPEED = 5;
    private int speed;
    //圖片寬高
    public static final int BARRIER_WIDTH = imgs[0].getWidth();
    public static final int BARRIER_HEIGHT = imgs[0].getHeight();
    //相對XY
    private int x,y;
    private int width,height;
    private int type;
    public static final int TYPE_TOP_NORMAL = 0;
    //碰撞區設定
    private Rectangle rect;

    public Barrier(int x,int y,int height,int type){
        super();
        this.x = x;//x = 400
        this.y = ran.nextInt(400);//y = 0
        this.height = height;//沒用到
        this.type = type;//沒用到
        this.width = BARRIER_WIDTH;//沒用到
        this.speed = MIN_SPEED;//沒用到
        //碰撞區
        rect = new Rectangle();
        rect.width = this.width;
    }

    //隨機產生障礙物
    Random ran = new Random();
    public final int INDEX = ran.nextInt(5);

    //畫出障礙物
    public void draw(Graphics g){
        drawTopNormal(g);
        //TODO 碰撞區(是否顯示)
        //g.setColor(Color.BLACK);
        //g.drawRect(rect.x, rect.y, rect.width, rect.height);
        logic();
    }

    //創建各種不同的障礙物
    private void drawTopNormal(Graphics g){
        switch (INDEX){
            case 0:/*衛星*/
                g.drawImage(imgs[0], x+430, y, null);
                rect.x = x+440; rect.y = y+10;
                rect.width = imgs[0].getWidth()-30;
                rect.height = imgs[0].getHeight()-30;
                break;
            case 1:/*垃圾*/
                g.drawImage(imgs[2], x+430, y+10, 100,100,null);
                rect.x = x+440; rect.y = y+20;
                rect.width = 70;
                rect.height = 70;
                break;
            case 2:/*封包*/
                g.drawImage(imgs[3], x+400, y, null);
                rect.x = x+410; rect.y = y+60;
                rect.width = imgs[3].getWidth()-15;
                rect.height = 75;
                break;
            case 3:/*火山噴發*/
                g.drawImage(imgs[4], x+360, 300, 300,300,null);
                rect.x = x+380; rect.y = 320;
                rect.width = 300-20; rect.height = 300-20;
                break;
            case 4:/*火山*/
                g.drawImage(imgs[5], x+360, 150, 500,500,null);
                rect.x = x+450; rect.y = 400;
                rect.width = 350; rect.height = 300;
                break;
            case 5:/*飛彈*/
                g.drawImage(imgs[1], x, 0, null);
                break;
        }
        //System.out.print(x+" "+y+" ");
        //System.out.print(Constant.Frame_Width+" "+Constant.Frame_Height+" ");
    }

    //障礙物左移
    private void logic(){
        switch (INDEX){
            case 0:/*衛星*/
                x -= speed+5;
                rect.x -= speed+5;
                break;
            case 1:/*垃圾*/
                x -= speed+10;
                rect.x -= speed+10;
                break;
            case 2:/*封包*/
                x -= speed+20;
                rect.x -= speed+20;
                break;
            case 3:/*火山噴發*/
            case 4:/*火山*/
                x -= speed+2;
                rect.x -= speed+2;
                break;
            case 5:/*飛彈*/
                y += speed+15;
                rect.y -= speed+2;
                break;
        }

    }

    //太常用我受不了了
    public int getX(){
        return x;
    }
    public int getHeight(){return height;}

    //判斷障礙物位置是否在視窗內
    public boolean IsInFrame(){
        return (x+imgs[INDEX].getWidth())<Constant.Frame_Width;
    }

    //碰撞區矩形的屬性
    public void setAttribute(int x,int y,int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.type = type;
    }
    public void setRectangle(int x,int y,int height){
        rect.x = x;
        rect.y = y;
        rect.height = height;
    }
    public Rectangle getRect(){return rect;}
}
