package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WPanel extends JPanel implements KeyListener {
    //加载所有图片
    ImageIcon up = new ImageIcon("up.png");
    ImageIcon down = new ImageIcon("down.png");
    ImageIcon left = new ImageIcon("left.png");
    ImageIcon right = new ImageIcon("right.png");
    ImageIcon title = new ImageIcon("title.jpg");
    ImageIcon body = new ImageIcon("body.png");
    ImageIcon food = new ImageIcon("food.png");

    //初始默认长度为3
    int len = 3;
    //使用两个数组存储x,y坐标
     int[]snakex = new int[750];
     int[]snakey = new int[750];
    static int pixel = 25;
    String direction = "L";//R右，L左，U上，D下
    //判断是否开始的变量
    boolean isStarted = false;
    public WPanel(){
        initSanke();
        //是否获得焦点
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void paintComponent(Graphics graphics){
//        System.out.println("传入画笔，我被调用了！"+ graphics);
        //调用父类的方法
        super.paintComponent(graphics);
        this.setBackground(Color.white);

        title.paintIcon(this,graphics,25,11);
        //填充矩形
        graphics.fillRect(25,75,850,600);
        //画出头部与两段身体
//        right.paintIcon(this,graphics,100,100);
//        body.paintIcon(this,graphics,75,100);
//        body.paintIcon(this,graphics,50,100);

        //控制头部的朝向
        switch (direction){
            case "R":
                right.paintIcon(this,graphics,snakex[0],snakey[0]);
                break;
            case "L":
                left.paintIcon(this,graphics,snakex[0],snakey[0]);
                break;
            case "U":
                up.paintIcon(this,graphics,snakex[0],snakey[0]);
                break;
            case "D":
                down.paintIcon(this,graphics,snakex[0],snakey[0]);
                break;
            default:
                System.out.println("操作有误！");
        }

        for (int i = 1; i< len;i++){
            body.paintIcon(this,graphics,snakex[i],snakey[i]);
        }

        //开始游戏提示
        if (!isStarted){
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("arial",Font.BOLD,40));
            graphics.drawString("Press Space To Start",250,300);
        }
    }

    public void initSanke(){
       int len = 3;
       for (int x = 0;x<3;x++){
           switch (x){
               case 0:
                   snakex[x] = pixel*4;
                   snakey[x] = pixel*4;
                   break;
               case 1:
                   snakex[x] = pixel*3;
                   snakey[x] = pixel*4;
                   break;
               case 2:
                   snakex[x] = pixel*2;
                   snakey[x] = pixel*4;
                   break;
           }


       }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println(e.getKeyCode());
    }
}
