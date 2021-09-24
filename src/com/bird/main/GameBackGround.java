package com.bird.main;
import com.bird.util.Constant;
import com.bird.util.GameUtil;
import java.awt.*;

public class GameBackGround {

    private Image bkImg;
    public GameBackGround(){
        bkImg = GameUtil.loadBufferedImage(Constant.BK_IMG_PATH01);
    }

    //畫圖函式
    public void draw(Graphics g){
        g.setColor(Constant.BK_Color);
        g.fillRect(0,0,Constant.Frame_Width,Constant.Frame_Height);
        int imgW = bkImg.getWidth(null);
        int imgH = bkImg.getHeight(null);
        int count = Constant.Frame_Width/imgW+1;
        g.drawImage(bkImg,0,0, Constant.Frame_Width, Constant.Frame_Height,null);
        //TODO 失敗的背景滾動
        //for(int i=0;i<count;i++){
        //    g.drawImage(bkImg,imgW*i,Constant.Frame_Height,null);
        //}
    }
}
