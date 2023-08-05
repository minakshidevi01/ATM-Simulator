package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    JButton changeButton, back;
    String pinnumber;
    JPasswordField pin1, rePin, curPin;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(256, 300, 500, 35);
        image.add(text);
        
        JLabel currentText = new JLabel("Current Pin :");
        currentText.setForeground(Color.WHITE);
        currentText.setFont(new Font("System", Font.BOLD, 16));
        currentText.setBounds(165, 380, 180, 25);
        image.add(currentText);
        
        curPin = new JPasswordField();
        curPin.setFont(new Font("Raleway", Font.BOLD, 16));
        curPin.setBounds(330, 380, 180, 25);
        image.add(curPin);
        
        JLabel pinText = new JLabel("New Pin :");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 380, 180, 25);
        image.add(pinText);
        
        pin1 = new JPasswordField();
        pin1.setFont(new Font("Raleway", Font.BOLD, 16));
        pin1.setBounds(330, 380, 180, 25);
        image.add(pin1);
        
        JLabel rePinText = new JLabel("Re-Enter New Pin :");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 430, 500, 35);
        image.add(rePinText);
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 16));
        rePin.setBounds(330, 435, 180, 25);
        image.add(rePin);
        
        changeButton = new JButton("CHANGE");
        changeButton.setBounds(355, 487, 150, 29);
        changeButton.addActionListener(this);
        image.add(changeButton);
        
        back = new JButton("BACK");
        back.setBounds(355, 522, 150, 28);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == changeButton){
                try{
                    String npin = pin1.getText();
                    String rpin = rePin.getText();
                    
                    if(npin.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter new PIN");
                        return;
                    }if(rpin.equals("")){
                        JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                        return;
                    }if(!npin.equals(rpin)){
                        JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                        return;
                    }
                    
                    Conn conn = new Conn();
                    String query1 = "update bank set pinNumber = '"+rpin+"' where pinNumber='"+pinnumber+"'";
                    String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber='"+pinnumber+"'";
                    String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber='"+pinnumber+"'";
                    
                    //As it is DML command so we need to use executeUpdate() 
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    
                    setVisible(false);
                    new Transaction(rpin).setVisible(true);
                }catch(Exception e){
                    System.out.print(e);
                }
            }else if(ae.getSource() == back){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
    }
    public static void main(String args[]) {
       new PinChange("");
    }
}
