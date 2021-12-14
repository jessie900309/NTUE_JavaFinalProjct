# NTUE_JavaFinalProjct

###### tags: `NTUE_SchoolHomework`

#### 國立台北教育大學 109學年度 視窗程式設計 期末專題

<!-- #### 改寫自[尚学堂杨老师-java教学-java游戏制作-像素鸟游戏（Flappy Bird）](https://www.bilibili.com/video/BV1oc411h75E?p=1) -->

#### 畫面簡介

|   封面   | ![](https://i.imgur.com/BTm0l7F.jpg) |          |
|:--------:|:--------:|:--------:|
|   P.01   |   P.02   |   P.03   |
| ![](https://i.imgur.com/lmMNCTf.jpg) | ![](https://i.imgur.com/nbc1k0R.jpg) | ![](https://i.imgur.com/aOJzvmt.jpg) |
|   P.04   |   P.05   |   P.06   |
| ![](https://i.imgur.com/IR76Bm4.jpg) | ![](https://i.imgur.com/jwqyWaw.jpg) | ![](https://i.imgur.com/CwPcUbH.jpg) |
|   P.07   |   P.08   |   P.09   |
| ![](https://i.imgur.com/v6PgAln.jpg) | ![](https://i.imgur.com/NBCpBcw.jpg) | ![](https://i.imgur.com/6FlCbrF.jpg) |


#### src/com/bird/app/

* GameApp.java
    * 主函式執行

#### src/com/bird/main/

* Barrier.java
    * 障礙物
* Bird.java
    * 主角喵喵
* GameBackGround.java
    * 遊戲背景
* GameBarrierLayer.java
    * 添加障礙物、判斷所有障礙物與喵喵的碰撞
* GameFrame.java
    * 遊戲視窗(主要運作)
* GameNotice.java
    * 死亡畫面
* GameReady.java
    * 初始畫面

#### src/com/bird/util/

* Constant.java
    * 遊戲所需的常數
* GameUtil.java
    * loadBufferedImage 載入圖片

#### img/

* background01.png
    * 遊戲背景
* notice.jpg
    * 死亡畫面
* role_01.png
    * 喵喵下降
* role_02.png
    * 喵喵上飛
* role_d01.png / role_d02.png
    * 喵喵死掉
* title.jpg
    * 初始畫面
* trash_01.png / trash_02.png / trash_03.png / trash_04.png / trash_05.png / trash_06.png
    * 各式障礙物

:::danger
圖片皆為本人所繪，禁止盜用喔喵Ou<
:::
