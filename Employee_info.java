package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,400);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);
        
        try{
            conn c=new conn();
            String q="select * from Emp_info";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1=new JLabel("Name");
        label1.setBounds(11,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 =new JLabel("Age");
        label2.setBounds(176,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 =new JLabel("Phone number");
        label3.setBounds(335,9,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 =new JLabel("Salary");
        label4.setBounds(500,9,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 =new JLabel("Gmail");
        label5.setBounds(660,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 =new JLabel("Aadhar number");
        label6.setBounds(830,9,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton b1=new JButton("Back");
        b1.setBounds(350,450,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }

        });
        setUndecorated(true);
        setSize(1000,500);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new Employee_info();
    }
}
