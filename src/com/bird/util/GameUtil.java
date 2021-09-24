package com.bird.util;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class GameUtil {

    private GameUtil(){ }

    public static BufferedImage loadBufferedImage(String imgPath){
        try {
            return ImageIO.read(new FileInputStream(imgPath));
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
