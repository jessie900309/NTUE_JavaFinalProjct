package com.bird.main;
import com.bird.util.Constant;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class GameBarrierLayer {

    private List<Barrier> barriers;

    public GameBarrierLayer(){
        barriers = new ArrayList<>();
        initBarriers();
    }
    private void initBarriers(){
        barriers.add(new Barrier(Constant.Frame_Width/2,0,Constant.Frame_Height/2,Barrier.TYPE_TOP_NORMAL));
    }

    public void draw(Graphics g, Bird bird){
        for(int i = 0;i < barriers.size();i++){
            barriers.get(i).draw(g);
        }
        //碰撞檢測
        Bird.Cbird = collideBird(bird);
        logic();
    }

    //添加障礙物
    private void logic(){
        if(barriers.size()==0){
            //遊戲開始，產生障礙物
            Barrier PPP = new Barrier(0,0,0,0);
            barriers.add(PPP);
            PPP.setAttribute(Constant.Frame_Width,0,PPP.getHeight());
            PPP.setRectangle(Constant.Frame_Width,0,PPP.getHeight());
        }else{
            //一個進來再加一個
            Barrier last = barriers.get(barriers.size()-1);
            if(last.IsInFrame()){
                int X = last.getX() + 180;
                Barrier QQQ = new Barrier(X,0,0,0);
                barriers.add(QQQ);
            }
        }
    }

    //判斷所有障礙物與喵喵的碰撞
    public boolean collideBird(Bird bird){
        for (int i=0;i<barriers.size();i++){
            Barrier barrier = barriers.get(i);
            if(barrier.getRect().intersects(bird.getRect()) || bird.getRect().intersects(barrier.getRect())){
                System.out.print("Collision!!!\n");
                return false;
            }
        }return true;
    }
}
