
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    JRadioButton saving, fixed_deposit, current_account, recurring_deposit;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignUpThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 30));
        l1.setBounds(290, 40, 400, 40);
        add(l1);
        
        JLabel l2 = new JLabel("Account Type :");
        l2.setFont(new Font("Raleway", Font.BOLD, 23));
        l2.setBounds(100, 110, 300, 30);
        add(l2);
        
        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 17));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100, 150, 230, 25);
        add(saving);
        
        fixed_deposit = new JRadioButton("Fixed Deposit Account");
        fixed_deposit.setFont(new Font("Raleway", Font.BOLD, 17));
        fixed_deposit.setBackground(Color.WHITE);
        fixed_deposit.setBounds(450, 150, 280, 25);
        add(fixed_deposit);
        
        current_account = new JRadioButton("Current Account");
        current_account.setFont(new Font("Raleway", Font.BOLD, 17));
        current_account.setBackground(Color.WHITE);
        current_account.setBounds(100, 180, 230, 25);
        add(current_account);
        
        recurring_deposit = new JRadioButton("Recurring Deposit Account");
        recurring_deposit.setFont(new Font("Raleway", Font.BOLD, 17));
        recurring_deposit.setBackground(Color.WHITE);
        recurring_deposit.setBounds(450, 180, 280, 25);
        add(recurring_deposit);
        
        ButtonGroup b1 = new ButtonGroup();
        b1.add(saving);
        b1.add(fixed_deposit);
        b1.add(current_account);
        b1.add(recurring_deposit);
        
        JLabel l3 = new JLabel("Card Number :  ");
        l3.setFont(new Font("Raleway", Font.BOLD, 23));
        l3.setBounds(100, 260, 300, 30);
        add(l3);
        
        JLabel l31 = new JLabel("(Your 16 Digit Card Number)");
        l31.setFont(new Font("Raleway", Font.BOLD, 12));
        l31.setBounds(100, 285, 200, 25);
        add(l31);
        
        JLabel l32 = new JLabel("XXXX-XXXX-XXXX-4184");
        l32.setFont(new Font("Raleway", Font.BOLD, 23));
        l32.setBounds(400, 260, 300, 30);
        add(l32);
        
        JLabel l4 = new JLabel("PIN :");
        l4.setFont(new Font("Raleway", Font.BOLD, 23));
        l4.setBounds(100, 356, 200, 25);
        add(l4);
        
        JLabel l41 = new JLabel("(Your 4 Digit Password)");
        l41.setFont(new Font("Raleway", Font.BOLD, 12));
        l41.setBounds(100, 376, 200, 25);
        add(l41);
        
        JLabel l42 = new JLabel("XXXX");
        l42.setFont(new Font("Raleway", Font.BOLD, 23));
        l42.setBounds(400, 356, 200, 25);
        add(l42);
        
        JLabel l5 = new JLabel("Services Required :");
        l5.setFont(new Font("Raleway", Font.BOLD, 23));
        l5.setBounds(100, 440, 400, 25);
        add(l5);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 17));
        c1.setBounds(100, 480, 230, 25); 
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 17));
        c2.setBounds(450, 480, 240, 25); 
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 17));
        c3.setBounds(100, 510, 230, 25);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("Emails and SMS Alert");
        c4.setFont(new Font("Raleway", Font.BOLD, 17));
        c4.setBounds(450, 510, 240, 25);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 17));
        c5.setBounds(100, 540, 230, 25);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 17));
        c6.setBounds(450, 540, 240, 25);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above-entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 14));
        c7.setBounds(100, 605, 650, 22);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 22));
        submit.setBounds(100, 680, 160, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 22));
        cancel.setBounds(450, 680, 160, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == submit){
           String accountType = "";
           if(saving.isSelected()){
               accountType = "Saving Account";
           } else if(fixed_deposit.isSelected()){
               accountType = "Fixed Deposit Account";
           } else if(current_account.isSelected()){
               accountType = "Current Account";
           } else if(recurring_deposit.isSelected()){
               accountType = "Recurring Deposit Account";
           }
           
           Random random = new Random();
           String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L); 
           String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);        //we can use int either in PIN
           
           String facility = "";
           if(c1.isSelected()){
              facility = facility + " ATM Card";
           }else if(c2.isSelected()){
              facility = facility + " Internet Banking";
           }else if(c3.isSelected()){
              facility = facility +" Mobile Banking";
           }else if(c4.isSelected()){
              facility = facility + " Emails and SMS Alert";
           }else if(c5.isSelected()){
              facility = facility + " Cheque Book";
           }else if(c6.isSelected()){
              facility = facility + " E-Statement";
           }
           
           String validity = "";
           if(c7.isSelected()){
              validity = "Valid Declaration";
           }
           
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account Type is Required");
               }else if(facility.equals("")){
                   JOptionPane.showMessageDialog(null, "Facility is Required");
               }else if(validity.equals("")){
                   JOptionPane.showMessageDialog(null, "Validity is Required");
               }else{
                   Conn conn = new Conn();
                   String query1 = "Insert into signupthree values('"+formno+ "', '"+accountType+ "', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                   String query2 = "Insert into login values('"+formno+ "', '"+cardNumber+"', '"+pinNumber+"')";

                  
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: "+ pinNumber);
                   
                   setVisible(false);
                   new Deposit(pinNumber).setVisible(true);
               }
           }catch(Exception e){
               System.out.println(e);
           }
           
       }else if(ae.getSource() == cancel){
           setVisible(false);
           new Login().setVisible(true);
       }
    }
    
    public static void main(String args[]) {
       new SignUpThree("");
    }
}
