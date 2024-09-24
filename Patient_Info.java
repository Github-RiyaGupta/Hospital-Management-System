package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_Info extends JFrame {
    Patient_Info(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,50,990,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from Patient_Info";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("ID");
        label1.setBounds(10,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 =new JLabel("Number");
        label2.setBounds(135,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 =new JLabel("Name");
        label3.setBounds(260,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 =new JLabel("Gender");
        label4.setBounds(385,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 =new JLabel("Disease");
        label5.setBounds(510,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 =new JLabel("Room no.");
        label6.setBounds(630,11,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7 =new JLabel("Time");
        label7.setBounds(755,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8 =new JLabel("Deposite");
        label8.setBounds(880,11,100,17);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton b1=new JButton("Back");
        b1.setBounds(450,510,120,30);
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
        setSize(1000,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }
    public static void main(String[] args){
        new Patient_Info();
    }
}
