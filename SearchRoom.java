package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    SearchRoom(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label1=new JLabel("Search for Room");
        label1.setBounds(250,11,186,31);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 =new JLabel("Status");
        label2.setBounds(70,70,80,20);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label2);

        choice=new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,150,800,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.black);
        panel.add(table);

        try{
            conn c=new conn();
            String q="select * from Room";
            ResultSet rs=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 =new JLabel("Room No.");
        label3.setBounds(2,162,120,20);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label3);

        JLabel label4 =new JLabel("Availability");
        label4.setBounds(200,125,120,23);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label4);

        JLabel label5 =new JLabel("Price");
        label5.setBounds(400,125,120,20);
        label5.setForeground(Color.white);
        label5.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label5);

        JLabel label6 =new JLabel("Bed Type");
        label6.setBounds(600,125,120,23);
        label6.setForeground(Color.white);
        label6.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label6);

        JButton b1=new JButton("Search");
        b1.setBounds(200,400,80,20);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from Room where Availability='"+choice.getSelectedItem()+"'";
                try{
                    conn c=new conn();
                    ResultSet rs1=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton b2=new JButton("Back");
        b2.setBounds(380,400,80,25);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
