package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;                              //ResultSet
import javax.swing.JOptionPane;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    //Global Declaration
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel amount = new JLabel("Select Withdrawl Amount");
        amount.setBounds(218, 300, 700, 35);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        image.add(amount);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 417, 150, 28);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355, 417, 150, 28);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 452, 150, 28);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355, 452, 150, 28);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170, 487, 150, 28);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355, 487, 150, 28);
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(355, 522, 150, 28);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);      
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);            // ae.getSource() will return an obj so we need to typecast it
            Conn c = new Conn();                                                              // we need to make a connection with database
            // Exception handling
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){                                                                  //rs.next() helps in looping each row
                    if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                }
                
                else{
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+ " Debited Successfully");
                
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    


    public static void main(String args[]) {
               new FastCash("");
        }
}