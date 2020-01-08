package snake;

import javax.swing.*;

public class SnakeMain {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设定窗口出现位置x,y分别是距边框的距离 屏幕左上角为原点
        jFrame.setBounds(100,100,900,720);
        //是否允许改变窗口大小
        jFrame.setResizable(false);
        //关闭操作
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(new WPanel());
        //绘制窗口
        jFrame.setVisible(true);
    }
}
