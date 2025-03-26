package com.Mygame1.First.ui;

import cn.hutool.core.io.FileUtil;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class RegisterJFrame extends JFrame implements MouseListener {
    //创建一个集合
    ArrayList<User> allUser;
    //2.添加用户名输入框
    JTextField username = new JTextField();
    //4.密码输入框
    JTextField password = new JTextField();
    //5.添加注册按钮
    JButton register = new JButton();
    //6.添加重置按钮
    JButton reset = new JButton();
    //4.再次输入密码框
    JTextField rePassword = new JTextField();

    public RegisterJFrame(ArrayList<User> allUser) {
        this.allUser = allUser;
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("day2.27\\image\\register\\注册用户名.png"));
        usernameText.setBounds(80, 135, 100, 17);
        this.getContentPane().add(usernameText);


        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("day2.27\\image\\register\\注册密码.png"));
        passwordText.setBounds(90, 195, 70, 16);
        this.getContentPane().add(passwordText);


        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //再次输入密码提示
        JLabel rePasswordText = new JLabel(new ImageIcon("day2.27\\image\\register\\再次输入密码.png"));
        rePasswordText.setBounds(60, 256, 115, 30);
        this.getContentPane().add(rePasswordText);

        rePassword.setBounds(195, 256, 200, 30);
        this.getContentPane().add(rePassword);



        register.setBounds(123, 310, 128, 47);
        register.setIcon(new ImageIcon("day2.27\\image\\register\\注册按钮.png"));
        register.addMouseListener(this);
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);


        reset.setBounds(256, 310, 128, 47);
        reset.setIcon(new ImageIcon("day2.27\\image\\register\\重置按钮.png"));
        //去除按钮的默认边框
        reset.setBorderPainted(false);
        //去除按钮的默认背景
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);
        this.getContentPane().add(reset);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("day2.27\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    public void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0注册");//设置标题
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
        jDialog.setSize(500, 150);
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
          if(e.getSource() == register) {
              //如果点击了注册
              if (username.getText().length() == 0 || password.getText().length() == 0|| rePassword.getText().length() == 0) {
                  //判断输入框是否为空
                  showJDialog("用户名或密码不能为空");
                   return;
               } else if (!password.getText().equals(rePassword.getText())) {
                  //判断密码输入是否一致
                   showJDialog("密码输入不一致");
                   return;
              }
              //判断用户名和密码的格式是否正确
              if(!username.getText().matches("[a-zA-Z0-9]{4,16}")){
                    showJDialog("用户名格式有误!");
                    return;
              }
              if(!password.getText().matches("\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[a-z])\\S*")){
                  showJDialog("密码格式有误，至少包含一个字母，一个数字，长度6位!");
                  return;
              }
              //判断用户名是否存在
              if(containsUserName(username.getText())) {
                  showJDialog("用户名已存在");
                  return;
              }
              //添加用户
              allUser.add(new User(username.getText(), password.getText()));
              //写入数据
              FileUtil.writeLines(allUser,"F:\\idea_2024\\study\\text\\day2.27\\src\\userinfo.txt","UTF-8");
              //提示注册成功
              showJDialog("注册成功！");
              //关闭注册页面  打开登录页面
              this.setVisible(false);
              new LoginJFrame();
          }else if(e.getSource() == reset) {
              //如果点击重置
              username.setText("");
              password.setText("");
              rePassword.setText("");
          }
    }
    //作用 判断用户名是否存在
    //存在 返回ture
    //不存在 返回false
    public boolean containsUserName(String username) {
        for (User user : allUser) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==register){
            register.setIcon(new ImageIcon("day2.27\\image\\register\\注册按下.png"));
        }else if(e.getSource()==reset){
            reset.setIcon(new ImageIcon("day2.27\\image\\register\\重置按下.png"));
        }
    }

    //松开
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==register){
            register.setIcon(new ImageIcon("day2.27\\image\\register\\注册按钮.png"));
        }else if(e.getSource()==reset){
            reset.setIcon(new ImageIcon("day2.27\\image\\register\\重置按钮.png"));
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

}