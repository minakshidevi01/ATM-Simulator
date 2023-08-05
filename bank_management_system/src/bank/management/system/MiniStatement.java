package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;
    
    
    
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        setTitle("Mini Statement");
        
        JLabel mini = new JLabel();
        mini.setBounds(30, 150, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(135, 40, 200, 22);
        bank.setFont(new Font("System", Font.BOLD, 18));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(30, 100, 340, 21);
        card.setFont(new Font("System", Font.BOLD, 18));
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(30, 400, 300, 20);
        add(balance);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNumber = '"+pinnumber+"'");  
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinNumber = '"+pinnumber+"'");       
            while(rs.next()){
                //Use of HTML for taking space ("&nbsp;" put spaces)
                mini.setText(mini.getText() + "<html>" +rs.getString("date") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + 
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");                //setText() overwrites so for appending we are using getText() with rs.getString()
                if(rs.getString("type").equals("Deposit")){
                            bal += Integer.parseInt(rs.getString("amount"));
                }else{
                            bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+ bal);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
