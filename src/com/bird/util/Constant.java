package com.bird.util;
import java.awt.*;

public class Constant {

    //視窗大小
    public static final int Frame_Width = 800;
    public static final int Frame_Height = 600;
    //視窗標題
    public static final String Game_Title = "Cat Flying";
    //視窗位置 左上角為(0,0)
    public static final int Frame_X = 250;//向右
    public static final int Frame_Y = 150;//向下

    //圖片路徑
    public static final  int GAME_INTERVAL = 5;//更新間隔

    /*主角*/
        public static final String[] BIRD_IMG_PATH =
                {"img/role_01.png","img/role_02.png","img/role_d02.png"};
        public static final String[] BARRIER_IMG_PATH =
                {"img/trash_01.png","img/trash_02.png","img/trash_03.png",
                 "img/trash_04.png","img/trash_05.png","img/trash_06.png"};
    /*背景色*/
        public static final Color BK_Color = new Color(0x4bc4cf);
    /*背景圖*/
        public static final String TITLE_IMG_PATH = "img/title.jpg";
        public static final String NOTICE_IMG_PATH = "img/notice.jpg";
        public static final String BK_IMG_PATH01 = "img/background01.png";
    /*標題欄高度*/
        public static final int TOP_BAR_HEIGHT = 20;
}
