package swingPc;

import cmd.StructureSystem;
import tools.Hint;
import tools.HttpUtils;
import tools.Image;
import tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login{

    private static JPanel jPanelName;
    private static JPanel jPanelPassword;
    private JPanel jPanelMenu;
    private JPanel menu;

    private JLabel jLabelName;
    private JLabel jLabelPassword;

    private JTextField jTextFieldName;
    private JTextField jTextFieldPassword;

    private static JButton jButtonLogin;
    private JButton jButtonRegister;
    private JButton jButtonForgetPassword;

    public Login(JFrame jFrame){
        //super();
//        jFrame=new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(new FlowLayout());

        menu =new JPanel(new GridLayout(3,1,8,8));

        //获取桌面大小
        Tool tool=new Tool();

        //设置背景图片
        Image image = new Image();
        JLabel label = image.label();
        jFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel jPanel = (JPanel)jFrame.getContentPane();
        jPanel.setOpaque(false);

        jTextFieldName=image.getJTextField(jTextFieldName);
        jTextFieldPassword=image.getJTextField(jTextFieldPassword);

        //添加输入框
        menu.add(image.getJPanel(jPanelName,jTextFieldName,jLabelName,"用户名:"));
        menu.add(image.getJPanel(jPanelPassword,jTextFieldPassword,jLabelPassword,"密\u3000码:"));

        //按键初始化
        jButtonLogin=image.getJButton(jButtonLogin,"登\u3000\u3000录");
        jButtonRegister=image.getJButton(jButtonRegister,"注\u3000\u3000册");
        jButtonForgetPassword=image.getJButton(jButtonForgetPassword,"忘记密码");

        //添加功能键
        menu.add(getJPanelMenu(jPanelMenu,jButtonLogin,jButtonRegister,jButtonForgetPassword));


        menu.setOpaque(false);
        jFrame.add(menu);

        //设置大小
        jFrame.setSize(label.getWidth(),label.getHeight());

        //设置当前位置
        jFrame.setLocation((tool.getDimension().width-label.getWidth())/2,
                (tool.getDimension().height-label.getHeight())/2);
        jFrame.setTitle("Login");
        jFrame.setVisible(true);

        //按键监听器
        jButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=jTextFieldName.getText();
                String password=jTextFieldPassword.getText();
                if (name.equals("")||password.equals("")){
                    Hint hint=new Hint("请输入用户名或密码!");
                    hint.setLocation((tool.getDimension().width-hint.getWidth())/2,
                            (tool.getDimension().height-hint.getHeight())/2);
                    hint.setVisible(true);
                    hint.setAlwaysOnTop(true);
                }else {
                    HttpUtils httpUtils=new HttpUtils();
                    new Thread(() ->{
                            try {
                                String login=httpUtils.httpLogin(name,password);
                                System.out.println(login);
                                if (login.equals(StructureSystem.SUCCESS)){
                                    System.out.println("SUCCESS");
                                }else {
                                    Hint hint=new Hint("用户名或密码错误!");
                                    hint.setLocation((tool.getDimension().width-hint.getWidth())/2,
                                            (tool.getDimension().height-hint.getHeight())/2);
                                    hint.setVisible(true);
                                    hint.setAlwaysOnTop(true);
                                }
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }

                    }).start();

                }
            }
        });

//        JFrame finalJFrame = jFrame;
        jButtonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(menu);
                Register register = new Register(jFrame,menu);
//                register.setVisible(true);
            }
        });

        jButtonForgetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }



    public JPanel getJPanelMenu(JPanel jPanel,JButton login,JButton register,JButton forget){
        if (jPanel == null){
            jPanel = new JPanel();
            jPanel.setLayout(new FlowLayout());
            jPanel.add(getJButton(forget,"忘记密码"));
            jPanel.add(getJButton(login,"登\u3000\u3000录"));
            jPanel.add(getJButton(register,"注\u3000\u3000册"));
            jPanel.setBackground(null);
            jPanel.setOpaque(false);
        }
        return jPanel;
    }


    public JButton getJButton(JButton jButton,String name){
        if (jButton == null){
            jButton = new JButton();
            jButton.setText(name);
            jButton.setBackground(Color.CYAN);

        }
        return jButton;
    }
}
