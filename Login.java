package hospital.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;

    Login(){

        JLabel namelabel=new JLabel("Username:");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        //namelabel.setForeground(Color.WHITE);
        add(namelabel);

        JLabel password=new JLabel("Password:");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        //namelabel.setForeground(Color.WHITE);
        add(password);

        textField=new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255,255,255));
        add(textField);

        jPasswordField=new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,255,255));
        add(jPasswordField);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image i1=imageIcon.getImage().getScaledInstance(350,320,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(320,2,400,300);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("Serif",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Serif",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);


    }
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b1){
            try{
                conn c=new conn();
                String user=textField.getText();
                String PW=jPasswordField.getText();

                String q="select * from login where ID ='"+user+"' and PW='"+PW+"'";
                ResultSet resultset=c.statement.executeQuery(q);

                if(resultset.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            System.exit(10);
        }

    }
    public static void main(String[] args){
        new Login();

    }


}