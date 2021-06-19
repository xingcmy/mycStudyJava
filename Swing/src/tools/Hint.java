package tools;

import javax.swing.*;
import java.awt.*;

public class Hint extends JFrame {
    public Hint(String hint){
        super();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());

        JLabel jLabel=new JLabel(hint);
        jLabel.setForeground(Color.RED);
        this.add(jLabel);
        this.setSize(250,100);
        this.setTitle("提示");
    }
}
