package com.Mygame1.First.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    //创建一个集合存储正确的用户名和密码
    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("zhangsan","123"));
        list.add(new User("lisi","1234"));
    }

    //2.添加用户名输入框
    JTextField username = new JTextField();
    //4.密码输入框
    JTextField password = new JTextField();
    //5.添加登录按钮
    JButton login = new JButton();
    //6.添加注册按钮
    JButton register = new JButton();
    //验证码的输入框
    JTextField code = new JTextField();
    String codeStr = CodeUtil.getCode();
    JLabel rightCode = new JLabel();

    public LoginJFrame() {
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("day2.27\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);


        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("day2.27\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);


        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("day2.27\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);


        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);


        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        rightCode.addMouseListener(this);
        //添加到界面
        this.getContentPane().add(rightCode);



        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("day2.27\\image\\login\\登录按钮.png"));
        login.addMouseListener(this);
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);


        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("day2.27\\image\\login\\注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("day2.27\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    public void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }


    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    //点击
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == login) {
            //如果点击了登录  开始获取用户信息并进行判断
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();

            //创建一个user 类型对象
            User userInfo = new User(usernameInput, passwordInput);
            if (codeInput.length() == 0) {
                showJDialog("验证码不能为空");
            } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("用户名或密码不能为空");
            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("验证码错误");
                rightCode.setText(codeStr);
            } else if (contains(userInfo)) {
                //登录成功
                //退出登陆界面
                //打开游戏界面
                this.setVisible(false);

                new GameJFrame();

            } else {
                showJDialog("用户名或密码错误");
            }

        }
        else if(e.getSource() == register) {

            showJDialog("注册界面");
        }else if(e.getSource() == rightCode) {
            rightCode.setText(CodeUtil.getCode());
        }
    }

    //按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==login){
            login.setIcon(new ImageIcon("day2.27\\image\\login\\登录按下.png"));
        }else if(e.getSource()==register){
            register.setIcon(new ImageIcon("day2.27\\image\\login\\注册按下.png"));
        }
    }

    //松开
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==login){
            login.setIcon(new ImageIcon("day2.27\\image\\login\\登录按钮.png"));
        }else if(e.getSource()==register){
            register.setIcon(new ImageIcon("day2.27\\image\\login\\注册按钮.png"));
        }
    }

    //划入
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    //划出
    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean contains(User userInfo) {
        for(int i=0;i<list.size();i++){
            if(userInfo.getName().equals(list.get(i).getName())&&
                    userInfo.getPassword().equals(list.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
}