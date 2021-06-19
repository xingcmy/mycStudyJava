package tools;

import javax.swing.*;
import java.awt.*;

public class Image {
    public JLabel label(){
        ImageIcon icon =new ImageIcon("images/61bc71603a6cd35ec2a8d31fe8f1b2d8.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        return label;
    }

    public JPanel getJPanel(JPanel jPanel,JTextField jTextField,JLabel jLabel,String name){
        if (jPanel == null){
            jPanel=new JPanel();
            jPanel.setLayout(new FlowLayout());
            jPanel.add(getJLabel(jLabel,name));
            jPanel.add(getJTextField(jTextField));
            jPanel.setBackground(null);
            jPanel.setOpaque(false);
        }
        return jPanel;
    }

    public JLabel getJLabel(JLabel jLabel,String name){
        if (jLabel == null){
            jLabel =new JLabel();
            jLabel.setBounds(34,49,53,18);
            jLabel.setText(name);
            jLabel.setForeground(Color.MAGENTA);
        }
        return jLabel;
    }



    public JTextField getJTextField(JTextField jTextField){
        if (jTextField == null){
            jTextField =new JTextField(20);
            //jTextField.setText(name);
            jTextField.setBackground(Color.CYAN);
        }
        return jTextField;
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
