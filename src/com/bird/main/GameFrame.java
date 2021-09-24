package com.bird.main;
import static com.bird.util.Constant.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends Frame implements Runnable{//java.awt.Frame

    //遊戲狀態

    public static final int STATE_READY = 0;
    public static final int STATE_PLAYING = 1;
    public static final int STATE_OVER = 2;
    private static int gameState = STATE_READY;


    public static int getGameState() {
        return gameState;
    }

    public static void setGameState(int gameState) {
        GameFrame.gameState = gameState;
    }

    //背景物件
    private GameBackGround backGround;
    private final BufferedImage bufimg = new BufferedImage(Frame_Width,Frame_Height,BufferedImage.TYPE_4BYTE_ABGR);

    //障礙物
    private GameBarrierLayer barrierLayer;

    //主角物件
    private Bird bird;

    //標題
    private GameReady gameReady;

    //結尾
    private GameNotice gameNotice;

    //建構子:定義視窗初始化工作
    public GameFrame(){
        //呼叫初始化函式
        initFrame();
        //初始化完成，視窗可見
        setVisible(true);
        //初始化背景
        initGame();
        new Thread(this).start();
    }

    //視窗初始化
    private void initFrame(){
        //視窗大小
        setSize(Frame_Width,Frame_Height);
        //視窗標題
        setTitle(Game_Title);
        //顯示在螢幕正中央
        setLocation(Frame_X,Frame_Y);
        //鎖定視窗大小
        setResizable(false);
        //事件:打叉關閉
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //按鍵監聽
        addKeyListener(new MyKeyListener());
    }

    //事件監聽者(空白鍵)
    class MyKeyListener implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(gameState == STATE_READY){
                if(keyCode == KeyEvent.VK_ENTER){
                    gameState = STATE_PLAYING;
                }
            }
            if(Bird.Cbird || barrierLayer.collideBird(bird)){
                if(keyCode == KeyEvent.VK_SPACE){
                    bird.fly();
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(Bird.Cbird && barrierLayer.collideBird(bird)){
                if(keyCode == KeyEvent.VK_SPACE){
                    bird.fall();
                }
            }
      }
        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

    //背景初始化
    private void initGame(){
        gameReady = new GameReady();
        backGround = new GameBackGround();
        bird = new Bird();
        barrierLayer = new GameBarrierLayer();
        gameNotice = new GameNotice();
        gameState = STATE_READY;
        //更新視窗
        new Thread(this).start();
    }

    //繪圖函式 : update屬jvm，且呼叫repaint()後繪製的圖形都會顯示在視窗上
    //g是畫筆，系統進行實例化
    //呼叫repaint() : 單獨啟動一段程式，不然會一直呼叫。
    public void update(Graphics g1){
        Graphics g = bufimg.getGraphics();
        if(gameState==STATE_PLAYING){
            backGround.draw(g);
            barrierLayer.draw(g,bird);
            bird.draw(g);
        }
        else{
            if(!Bird.Cbird){
                gameState=STATE_OVER;
            }
            if(gameState==STATE_OVER){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameNotice.draw(g);
            }
            else {
                gameReady.draw(g);
            }
        }
        g1.drawImage(bufimg, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            repaint();
            //
            try{
                Thread.sleep(GAME_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
