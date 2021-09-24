package com.bird.main;
import com.bird.util.GameUtil;
import com.bird.util.Constant;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameNotice {

    private final BufferedImage noticeImg = GameUtil.loadBufferedImage(Constant.NOTICE_IMG_PATH);;
    private int flush;
    public GameNotice(){
    }

    public void draw(Graphics g){
        g.drawImage(noticeImg,0,0,800,600,null);

    }
}