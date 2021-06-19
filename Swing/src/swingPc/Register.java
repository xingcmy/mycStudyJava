package swingPc;

import tools.Hint;
import tools.Image;
import tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register{

    private static JPanel jPanelName;
    private static JPanel jPanelPassword;
    private JPanel jPanelPasswordToo;
    private JPanel jPanelMenu;
    private JPanel jPanelHint;
    private JPanel RegisterMenu;

    private JLabel jLabelName;
    private JLabel jLabelPassword;
    private JLabel jLabelPasswordToo;
    private JLabel jLabelHint;

    private JTextField jTextFieldName;
    private JTextField jTextFieldPassword;
    private JTextField jTextFieldPasswordToo;

    private static JButton jButtonReturn;
    private JButton jButtonRegister;
    private JButton jButtonForgetPassword;
    public Register(JFrame jFrame,JPanel menu){
//        super();
//        jFrame=new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(new FlowLayout());

        RegisterMenu =new JPanel(new GridLayout(4,1,8,8));

        Tool tool=new Tool();

        //设置背景图片
        tools.Image image = new Image();
        JLabel label = image.label();

        jFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel jPanel = (JPanel)jFrame.getContentPane();
        jPanel.setOpaque(false);

        jTextFieldName=image.getJTextField(jTextFieldName);
        jTextFieldPassword=image.getJTextField(jTextFieldPassword);
        jTextFieldPasswordToo=image.getJTextField(jTextFieldPasswordToo);

        RegisterMenu.add(image.getJPanel(jPanelName,jTextFieldName,jLabelName,"用\u0020\u0020户\u0020\u0020名:"));
        RegisterMenu.add(image.getJPanel(jPanelPassword,jTextFieldPassword,jLabelPassword,"密\u3000\u3000码:"));
        RegisterMenu.add(image.getJPanel(jPanelPasswordToo,jTextFieldPasswordToo,jLabelPasswordToo,"确认密码:"));

        jButtonReturn=image.getJButton(jButtonReturn,"返\u3000\u3000回");
        jButtonRegister=image.getJButton(jButtonRegister,"注\u3000\u3000册");

        RegisterMenu.add(getJPanelMenu(jPanelMenu,jButtonRegister,jButtonReturn));

        jLabelHint=image.getJLabel(jLabelHint,"");



        RegisterMenu.setOpaque(false);
        jFrame.add(RegisterMenu);
        jFrame.setSize(label.getWidth(),label.getHeight());
        jFrame.setLocation((tool.getDimension().width-label.getWidth())/2,
                (tool.getDimension().height-label.getHeight())/2);
        jFrame.setTitle("Register");
        jFrame.setVisible(true);

        jButtonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  name=jTextFieldName.getText().toString();
                if (name.equals("")){
                    Hint hint=new Hint("请输入用户名!");
                    hint.setLocation((tool.getDimension().width-hint.getWidth())/2,
                            (tool.getDimension().height-hint.getHeight())/2);
                    hint.setVisible(true);
                    hint.setAlwaysOnTop(true);
                }else {
                    String password=jTextFieldPassword.getText();
                    String passwordToo=jTextFieldPasswordToo.getText();
                    if (password.equals(passwordToo)){

                    }else {
                        Hint hint=new Hint("密码不一致!");
                        hint.setLocation((tool.getDimension().width-hint.getWidth())/2,
                                (tool.getDimension().height-hint.getHeight())/2);
                        hint.setVisible(true);
                        hint.setAlwaysOnTop(true);
                    }
                }

            }
        });

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(RegisterMenu);
//                jFrame.setVisible(false);
                jFrame.dispose();
                jFrame.add(menu);
                jFrame.setVisible(true);
//                new Login(jFrame);
            }
        });
    }


    public JPanel getJPanelMenu(JPanel jPanel,JButton register,JButton jButtonReturn){
        if (jPanel == null){
            jPanel = new JPanel();
            jPanel.setLayout(new FlowLayout());
            jPanel.add(getJButton(jButtonReturn,"返\u3000\u3000回"));
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
