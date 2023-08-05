
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;                                                 //Date is in util package

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit, back;
    JLabel text;
    String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        text = new JLabel("Enter the amount you want to Deposit");
        text.setForeground(Color.WHITE);
        text.setBounds(195, 300, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(190, 350, 300, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 15));
        deposit.setBounds(357, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBounds(357, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else{
                try{
                    Conn conn = new Conn();                                  //Opening a connection with database
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);                        //DML Command
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                   }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Deposit("");
    }
}
