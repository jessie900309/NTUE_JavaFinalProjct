package com.bird.main;
import com.bird.util.GameUtil;
import com.bird.util.Constant;
import java.awt.image.BufferedImage;
import java.awt.*;

public class GameReady {

    private final BufferedImage titleImg = GameUtil.loadBufferedImage(Constant.TITLE_IMG_PATH);;
    private int flush;
    public GameReady(){
    }

    public void draw(Graphics g){
        g.drawImage(titleImg,0,0,800,600,null);

    }
}
