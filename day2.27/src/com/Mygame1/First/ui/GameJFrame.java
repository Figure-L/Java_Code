package com.Mygame1.First.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    int step =0;
    int[][] data = new int[4][4];
    int x=0;
    int y=0;
    //创建子选项
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportsItem = new JMenuItem("运动");


    JMenuItem accountItem = new JMenuItem("公众号");




    //定义一个变量存储图片路径
    String path = "day2.27\\image\\girl\\girl4\\";

    public GameJFrame() {
        //初始化窗口
        initJFrame();
        //初始化菜单
        initJMenuBar();


        //初始化数据
        initDate();
        //初始化图片
        initImage();
        //设置显示   建议写在最后
        this.setVisible(true);
    }

    private void initDate() {
        //定义一个一维数组
        int[] tempArr ={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; ;

        //打乱数据
        Random r =new Random();
        for(int i=0;i< tempArr.length;i++ ){
            int inder = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i]=tempArr[inder];
            tempArr[inder]=temp;
        }

        //赋值给二维数组
        for(int i=0;i<tempArr.length;i++){
            if(tempArr[i]==0){
                x=i/4;
                y=i%4;

            }
            data[i/4][i%4] = tempArr[i];
        }

    }

    private void initImage() {

        //清空上次图片
        this.getContentPane().removeAll();

        if(victory()){
            JLabel victoryLabel = new JLabel(new ImageIcon("F:\\idea_2024\\study\\text\\day2.27\\image\\win.png"));
            victoryLabel.setBounds(203,283,197,73);
            this.getContentPane().add(victoryLabel);
        }
        //先加载的 图片在上面

        JLabel stepCount = new JLabel("步数："+step);

        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        int i,j;
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                int num=data[i][j];
                //创建一个JLabel对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                //设置位置
                jLabel.setBounds(105*j+83, 105*i+134, 105,105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                //把管理容器添加到界面
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("day2.27\\image\\background.png"));

        background.setBounds(40,40,508,560);
        //显示背景图片
        this.getContentPane().add(background);

        //刷新
        this.getContentPane().repaint();
    }


    private void initJMenuBar(){
        //初始化菜单
        //创建整个的菜单对象

        JMenuBar jMenuBar = new JMenuBar();

        //创建上面两个选项
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");
        JMenu takePhoto = new JMenu("更换图片");

        //添加到对应的菜单栏
        functionMenu.add(takePhoto);
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        takePhoto.add(girlItem);
        takePhoto.add(animalItem);
        takePhoto.add(sportsItem);

        aboutMenu.add(accountItem);

        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportsItem.addActionListener(this);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        //再将俩个选项添加到总菜单
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);


        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
        this.addKeyListener(this);
    }


    private void initJFrame() {
        //设置宽高
        this.setSize(603, 680);

        //设置界面标题
        this.setTitle("拼图1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭窗口后直接结束程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //取消默认居中
        this.setLayout(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65)
        {
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //创建一个JLabel对象（管理容器）
            JLabel background = new JLabel(new ImageIcon("day2.27\\image\\background.png"));
            //设置位置
            background.setBounds(40, 40, 508,560);
            this.getContentPane().add(background);
            //刷新页面
            this.getContentPane().repaint();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(victory()){
            return;
        }

        if(code==37&&y!=3){
            System.out.println("向左");
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            step++;
            initImage();
        }
        else if(code == 38&&x!=3){
            System.out.println("向上");
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            step++;

            initImage();
        }
        else if(code == 39&&y!=0){
            System.out.println("向右");
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;

            initImage();
        }
        else if(code == 40&&x!=0){
            System.out.println("向下");
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            step++;

            initImage();
        }else if(code==65){
            initImage();
        }else if(code == 78){
            data =new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    public Boolean victory(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==replayItem){
            //计步清零
            step=0;
            //打乱数据
            initDate();
            //加载图像
            initImage();

        } else if (obj==reLoginItem) {
            //重新登录
            this.setVisible(false);

            new LoginJFrame();

        }else if(obj==closeItem){
            System.exit(0);
        }else if(obj==accountItem){
            //创建一个弹框对象
            JDialog jd = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("day2.27\\image\\about.png"));
            //设置位置与宽高
            jLabel.setBounds(0,0,258,258);
            //把图片放到弹窗中
            jd.getContentPane().add(jLabel);
            //给弹窗设置大小
            jd.setSize(344,344);
            //弹窗置顶
            jd.setAlwaysOnTop(true);
            //弹窗居中
            jd.setLocationRelativeTo(null);
            //弹窗不关闭无法进行下列操作
            jd.setModal(true);
            //让弹窗显示
            jd.setVisible(true);


        }else if(obj==girlItem){
            System.out.println("美女照片");
            Random r =new Random();
            int num = r.nextInt(10)+1;
            path = "day2.27\\image\\girl\\girl"+num+"\\";
            //计步清零
            step=0;
            //打乱数据
            initDate();
            //加载图像
            initImage();
        }
        else if(obj==animalItem){
            System.out.println("动物照片");
            Random r =new Random();
            int num = r.nextInt(8)+1;
            path = "day2.27\\image\\animal\\animal"+num+"\\";
            //计步清零
            step=0;
            //打乱数据
            initDate();
            //加载图像
            initImage();
        }
        else if(obj==sportsItem){
            System.out.println("运动照片");
            Random r =new Random();
            int num = r.nextInt(10)+1;
            path = "day2.27\\image\\sport\\sport"+num+"\\";
            //计步清零
            step=0;
            //打乱数据
            initDate();
            //加载图像
            initImage();
        }

    }
}
