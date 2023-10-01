/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package method;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author 84384
 */
public class Method {
//   private ImageIcon universe;
    public Method(){  
//create image
        
        ImageIcon universe= new ImageIcon(this.getClass().getResource("/resource/uni.jpg"));
        JLabel myLabel= new JLabel(universe);
        myLabel.setSize(400, 400);
//create frame
        Frame frame= new Frame("set");
        Panel panel = new Panel();
        panel.setBounds(20, 20, 360, 360);
        panel.setBackground(Color.BLACK);
//button copy
        Button button_copy= new Button("COPY");
        button_copy.setBounds(170, 300, 60, 30);
        button_copy.setBackground(Color.pink);
//button reset
        Button button_reset= new Button("reset");
        button_reset.setBounds(70, 300, 60, 30);
        button_reset.setBackground(Color.green);
//button paste
        Button button_paste= new Button("paste");
        button_paste.setBounds(270, 300, 60, 30);
        button_paste.setBackground(Color.BLUE);
//button exit
        Button button_exit= new Button("exit");
        button_exit.setBounds(170, 100, 38, 30);
        button_exit.setBackground(Color.red);
//add textfeild
        JTextField1 = new javax.swing.JTextField();
        //TextField JTextField1= new TextField("");
        JTextField1.setBounds(120, 200, 160, 30);
//add to frame
        frame.add(JTextField1); 
        frame.add(button_copy);
        frame.add(button_reset);
        frame.add(button_paste);
        frame.add(button_exit);
        frame.add(myLabel);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
//action copy
        button_copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField1.selectAll();
                JTextField1.copy();
            }
        });
//action reset
        button_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField1.setText("");
            }
        });
//action paste
        button_paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField1.paste();
            }
        });
//action exit
        button_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(frame,"Do you want to exit?","exit",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_NO_OPTION) {
                } else {
                    frame.dispose();
                }
            }
        });
    }
    private javax.swing.JTextField JTextField1;
}
