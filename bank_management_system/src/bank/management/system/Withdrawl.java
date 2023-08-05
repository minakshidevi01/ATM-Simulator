
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amt;
    JButton withdraw, back;
    JLabel text;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        text = new JLabel("Enter the amount you want to Withdrawl");
        text.setForeground(Color.WHITE);
        text.setBounds(195, 300, 400, 20);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        amt = new JTextField();
        amt.setBounds(190, 350, 300, 25);
        amt.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amt);
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway", Font.BOLD, 15));
        withdraw.setBounds(357, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
        String amount = amt.getText();
        if(ae.getSource() == withdraw){
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else{
                try{
                    Conn conn = new Conn();                                      //Opening a connection with database
                    ResultSet rs = conn.s.executeQuery("select * from bank where pinNumber = '"+pinnumber+"'");
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
                    }else{                            
                        String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                        conn.s.executeUpdate(query);                        //DML Command
                        JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrawl Successfully");

                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }
                }catch(Exception e){
                        System.out.print(e);
                       }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Withdrawl("");
    }
}
