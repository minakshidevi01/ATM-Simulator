
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    
        BalanceEnquiry(String pinnumber){
            this.pinnumber = pinnumber;
            setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 900, 900);
            add(image);

            back = new JButton("Back");
            back.setBounds(355, 522, 150, 28);
            back.setFont(new Font("System", Font.BOLD, 17));
            back.addActionListener(this);
            image.add(back);
            
                            
            Conn c = new Conn();                                                              // we need to make a connection with database
            int balance = 0;
            // Exception handling
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '"+pinnumber+"'");
                while(rs.next()){                                                             //rs.next() helps in looping each row
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                    System.out.println(e);
            }
            
            JLabel text = new JLabel("Your current account balance is Rs "+balance); 
            text.setForeground(Color.WHITE);
            text.setBounds(170, 300, 400, 30);
            image.add(text);
            
            
            
            
            
            setSize(900, 900);
            setLocation(300, 0);
            setUndecorated(true);
            setVisible(true);
        }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == back){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
