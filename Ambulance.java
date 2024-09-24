package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,50,790,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from Ambulance";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Name");
        label1.setBounds(10,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 =new JLabel("Gender");
        label2.setBounds(175,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 =new JLabel("Car Name");
        label3.setBounds(330,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 =new JLabel("Availability");
        label4.setBounds(490,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 =new JLabel("Location");
        label5.setBounds(640,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JButton b1=new JButton("Back");
        b1.setBounds(350,500,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }
    public static void main(String[] args){
        new Ambulance();
    }
}
