package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField; 
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
         
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200 , 40,400, 40);
        add(text);
        
        
        JLabel cardNo = new JLabel("Card Num: ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120 , 150,150, 40);
        add(cardNo);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300 , 150, 250, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardTextField);
        
        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120 , 230, 400, 40);
        add(pin);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300 , 230, 250, 40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 20));

        add(pinTextField);
        
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 310, 110, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(440, 310, 110 , 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 370, 250 , 40);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        
        setSize(800, 480);
        setLocation(350,200);
        setVisible(true);                   //Always write setVisible in end

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+ cardnumber + "' and pinNumber = '"+ pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);        //For DTL Command we use executeQuery Function
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);
            
        }
    }
    
    
    public static void main(String args[]) {
        new Login();
    }
}


