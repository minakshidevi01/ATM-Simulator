package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignUpOne extends JFrame implements ActionListener{
    JTextField nameTextField, fnameTextField, emailTextField, cityTextField, addressTextField, stateTextField, pinTextField;
    long random;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser; 
    JButton next;
    
    
     SignUpOne(){
         
         setLayout(null);
         
         Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L );
         
         JLabel formno = new JLabel("APPLICATION FORM NO. "+random );
         formno.setFont(new Font("Raleway", Font.BOLD, 38));
         formno.setBounds(140, 20, 600, 40);
         add(formno);
         
         JLabel personalDetails = new JLabel("Page 1: Personal Details");
         personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
         personalDetails.setBounds(290, 80, 400, 30);
         add(personalDetails);
         
         JLabel name = new JLabel("Name :");
         name.setFont(new Font("Raleway", Font.BOLD, 20));
         name.setBounds(100, 140, 200, 30);
         add(name);
         
         nameTextField = new JTextField();
         nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         nameTextField.setBounds(270, 140, 370, 30);
         nameTextField.addActionListener(this);
         add(nameTextField);
         
         JLabel fname = new JLabel("Father's Name : ");
         fname.setFont(new Font("Raleway", Font.BOLD, 20));
         fname.setBounds(100, 190, 200, 30);
         add(fname);
         
         fnameTextField = new JTextField();
         fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         fnameTextField.setBounds(270, 190, 370, 30);
         fnameTextField.addActionListener(this);
         add(fnameTextField);
         
         JLabel dob = new JLabel("Date Of Birth : ");
         dob.setFont(new Font("Raleway", Font.BOLD, 20));
         dob.setBounds(100, 240, 200, 30);
         add(dob);
         
         dateChooser = new JDateChooser();
         dateChooser.setBounds(270, 240, 370, 30);
         dateChooser.setForeground(new Color(105, 105, 105));
         add(dateChooser);
         
         JLabel gender = new JLabel("Gender : ");
         gender.setFont(new Font("Raleway", Font.BOLD, 20));
         gender.setBounds(100, 290, 200, 30);
         add(gender);
         
         male = new JRadioButton("Male");
         male.setBounds(270, 287, 130,40);
         male.setFont(new Font("Raleway", Font.BOLD, 18));
         male.setBackground(Color.WHITE);
         add(male);
         
         female = new JRadioButton("Female");
         female.setBounds(450, 287, 130,40);
         female.setFont(new Font("Raleway", Font.BOLD, 18));
         female.setBackground(Color.WHITE);
         add(female);
         
         ButtonGroup genderGroup = new ButtonGroup();
         genderGroup.add(male);
         genderGroup.add(female);
         
         JLabel Email = new JLabel("Email Address : ");
         Email.setFont(new Font("Raleway", Font.BOLD, 20));
         Email.setBounds(100, 340, 200, 30);
         add(Email);
         
         emailTextField = new JTextField();
         emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         emailTextField.setBounds(270, 340, 370, 30);
         emailTextField.addActionListener(this);
         add(emailTextField);
         
         JLabel marital = new JLabel("Marital Status : ");
         marital.setFont(new Font("Raleway", Font.BOLD, 20));
         marital.setBounds(100, 390, 200, 30);
         add(marital);
         
         married = new JRadioButton("Married");
         married.setBounds(270, 387, 130,40);
         married.setFont(new Font("Raleway", Font.BOLD, 18));
         married.setBackground(Color.WHITE);
         add(married);
         
         unmarried = new JRadioButton("Unmarried");
         unmarried.setBounds(410, 387, 130,40);
         unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
         unmarried.setBackground(Color.WHITE);
         add(unmarried);
         
         other = new JRadioButton("Other");
         other.setBounds(568, 386, 130,40);
         other.setFont(new Font("Raleway", Font.BOLD, 18));
         other.setBackground(Color.WHITE);
         add(other);
         
         ButtonGroup maritalGroup = new ButtonGroup();
         maritalGroup.add(married);
         maritalGroup.add(unmarried);
         maritalGroup.add(other);

         JLabel address = new JLabel("Address : ");
         address.setFont(new Font("Raleway", Font.BOLD, 20));
         address.setBounds(100, 440, 200, 30);
         add(address);
         
         addressTextField = new JTextField();
         addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         addressTextField.setBounds(270, 440, 370, 30);
         addressTextField.addActionListener(this);
         add(addressTextField);
         
         JLabel city = new JLabel("City : ");
         city.setFont(new Font("Raleway", Font.BOLD, 20));
         city.setBounds(100, 490, 200, 30);
         add(city);
         
         cityTextField = new JTextField();
         cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         cityTextField.setBounds(270, 490, 370, 30);
         cityTextField.addActionListener(this);
         add(cityTextField);
         
         JLabel state = new JLabel("State : ");
         state.setFont(new Font("Raleway", Font.BOLD, 20));
         state.setBounds(100, 540, 200, 30);
         add(state);
         
         stateTextField = new JTextField();
         stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         stateTextField.setBounds(270, 540, 370, 30);
         stateTextField.addActionListener(this);
         add(stateTextField);
         
         JLabel pincode = new JLabel("Pin Code : ");
         pincode.setFont(new Font("Raleway", Font.BOLD, 20));
         pincode.setBounds(100, 590, 200, 30);
         add(pincode);
         
         pinTextField = new JTextField();
         pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         pinTextField.setBounds(270, 590, 370, 30);
         pinTextField.addActionListener(this);
         add(pinTextField);
         
         next = new JButton("Next");
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setFont(new Font("Raleway", Font.BOLD, 20));
         next.setBounds(530, 650, 110, 40);
         next.addActionListener(this);
         add(next);
         
         getContentPane().setBackground(Color.WHITE );
         
         
         setSize(850, 800);
         setLocation(350, 10);
         setVisible(true);
     }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;  // long
        capitalizeFirstWord(nameTextField);
        String name = nameTextField.getText();
        capitalizeFirstWord(fnameTextField);
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        convertWordsToLowerCase(emailTextField);
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        capitalizeFirstWord(addressTextField);
        String address = addressTextField.getText();
        capitalizeFirstWord(cityTextField);
        String city = cityTextField.getText();
        capitalizeFirstWord(cityTextField);
        String state = stateTextField.getText();        
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "DOB is Required");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin is Required");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }else{
                Conn c = new Conn();
                String query = "Insert into signup values('"+formno+ "', '"+name+ "', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
             System.out.println(e);
        }
    } 
    
    
    private void capitalizeFirstWord(JTextField textField) {
        String text = textField.getText().trim();
        if (!text.isEmpty()) {
            // Convert the first word to uppercase
            String firstWordUpperCase = text.substring(0, 1).toUpperCase() + text.substring(1);
            textField.setText(firstWordUpperCase);
        }
    }
    
    private void convertWordsToLowerCase(JTextField textField) {
        String text = textField.getText().trim();
        if (!text.isEmpty()) {
            // Convert the words to lowercase
            String WordsToLowerCase = text.substring(0).toLowerCase();
            textField.setText(WordsToLowerCase);
        }
    }
   
    public static void main(String args[]) {
         new SignUpOne();
    }

    
}
