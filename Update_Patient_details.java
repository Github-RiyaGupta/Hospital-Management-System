package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient_details extends JFrame {
    Update_Patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 =new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(200,85,140,30);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 =new JLabel("Room No. :");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textField=new JTextField();
        textField.setBounds(200,129,140,20);
        panel.add(textField);

        JLabel label4 =new JLabel("In-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textField1 =new JTextField();
        textField1.setBounds(200,174,140,20);
        panel.add(textField1);

        JLabel label5 =new JLabel("Amount Paid (rs) :");
        label5.setBounds(25,216,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textField2 =new JTextField();
        textField2.setBounds(200,216,140,20);
        panel.add(textField2);

        JLabel label6 =new JLabel("Pending Amount (rs) :");
        label6.setBounds(25,261,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textField3 =new JTextField();
        textField3.setBounds(200,261,140,20);
        panel.add(textField3);

        JButton b1=new JButton("Check");
        b1.setBounds(156,378,89,23);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from Patient_Info where name='"+id+"'";
                try{
                    conn c=new conn();
                    ResultSet rs=c.statement.executeQuery(q);
                    while(rs.next()){
                        textField.setText(rs.getString("Room_Number"));
                        textField1.setText(rs.getString("TTime"));
                        textField2.setText(rs.getString("Deposite"));
                    }
                    ResultSet rs1=c.statement.executeQuery("select * from Room where room_no='"+textField.getText()+"'");
                    while(rs1.next()){
                        String price=rs1.getString("Price");
                        int amountpaid=Integer.parseInt(price)-Integer.parseInt(textField2.getText());
                        textField3.setText(""+amountpaid);
                    }

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton b2=new JButton("Update");
        b2.setBounds(56,378,89,23);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c=new conn();
                    String q=choice.getSelectedItem();
                    String room=textField.getText();
                    String time=textField1.getText();
                    String amount=textField2.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number='"+room+"',TTime='"+time+"',Deposite='"+amount+"' where Name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton b3=new JButton("Back");
        b3.setBounds(256,378,89,23);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args){
        new Update_Patient_details();
    }
}
