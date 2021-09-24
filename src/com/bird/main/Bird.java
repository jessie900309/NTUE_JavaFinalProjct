package com.bird.main;
import java.awt.*;
import com.bird.util.Constant;
import com.bird.util.GameUtil;

public class Bird {

    public static final int IMG_COUNT = 3;
    private Image[] imgs;
    private int x,y;
    private int delty = 0;
    public static final int MAX_UP_DELTY = 8;
    public static final int MAX_DOWN_DELTY = 15;

    private int state;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_UP = 1;
    public static final int STATE_DOWN = 2;

    //碰撞判定
    public static boolean Cbird = true;

    private Rectangle rect;

    //初始化貓貓
    public Bird(){
        imgs = new Image[IMG_COUNT];
        for(int i = 0;i<IMG_COUNT;i++){
            imgs[i] = GameUtil.loadBufferedImage(Constant.BIRD_IMG_PATH[i]);
        }
        //初始化座標Center
        x = Constant.Frame_Width/2-75;
        y = Constant.Frame_Height/2-70;

        //碰撞區設定
        int H = 180;
        int W = 180;
        int X = this.x - imgs[state].getWidth(null)/12/2;   //this.x : Constant.Frame_Width/2-75
        int Y = this.y - imgs[state].getHeight(null)/12/2;  //this.y : Constant.Frame_Height/2-70
        rect = new Rectangle(X+2,Y+2,W-4,H-4);
    }

    //畫出喵喵
    public void draw(Graphics g){
        flylogic();
        int halfImgW = imgs[state].getWidth(null)/12/2;
        int halfImgH = imgs[state].getHeight(null)/12/2;
        g.drawImage(imgs[state],x-halfImgW,y-halfImgH,200,180,null);//偏上
        //TODO 碰撞區(是否顯示)
        //g.setColor(Color.BLACK);
        //g.drawRect(x - imgs[state].getWidth(null)/12/2+50,y-halfImgH+50,140,65);
    }

    //貓貓在y軸的變化
     public void flylogic(){

        if(Cbird){
            switch (state){
                case STATE_NORMAL://初始不動
                    delty += 1;
                    if(delty > MAX_DOWN_DELTY){
                        delty = MAX_DOWN_DELTY;
                    }
                    y += delty;
                    rect.y = delty;
                    //撞到下面
                    //TODO
                    if(y > Constant.Frame_Height - imgs[state].getHeight(null)/12/2 - 30){
                        Cbird = false;
                        down();
                    }
                    break;

                case STATE_UP://上飛
                    delty++;
                    if(delty > MAX_UP_DELTY){
                        delty = MAX_UP_DELTY;
                    }
                    y -= delty;
                    rect.y = delty;
                    //撞到上面
                    //TODO
                    if(y < imgs[state].getHeight(null)/12/2 + Constant.TOP_BAR_HEIGHT){
                        Cbird = false;
                        down();
                    }
                    break;
            }
        }
        else {//死亡
            //case STATE_DOWN:
            down();
            Cbird = false;
            state = STATE_DOWN;
            delty += 15;
            y += delty;
            rect.y = delty;
            //System.exit(0);
            //break;
        }
    }

    //改變狀態向上
    public void fly(){
        System.out.println("up");
        //狀態只改變一次
        if(state != STATE_UP){
            state = STATE_UP;
            delty = 5;
        }

    }

    //正常狀態下落
    public void fall(){
        System.out.println("fall");
        state = STATE_NORMAL;
    }

    //改變狀態向下(死亡)
    public void down() {
        Cbird = false;
        System.out.println("state"+ GameFrame.getGameState());
        GameFrame.setGameState(2);
        System.out.println("death cat");
        state = STATE_DOWN;
        delty = 15;
    }

    //取得碰撞區
    public Rectangle getRect(){return rect;}
}
