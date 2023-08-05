
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener{

    JTextField pan_numberTextField, aadhar_numberTextField;
    JRadioButton eyes, eno, syes, sno;
    JButton next;
    JComboBox religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    String formno;
    
     SignUpTwo(String formno){
         this.formno = formno;
         setLayout(null);
         
         setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
         
         JLabel additionalDetails = new JLabel("Page 2: Additional Details");
         additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
         additionalDetails.setBounds(290, 60, 400, 30);
         add(additionalDetails);
         
         JLabel religion = new JLabel("Religion :");
         religion.setFont(new Font("Raleway", Font.BOLD, 20));
         religion.setBounds(100, 140, 200, 30);
         add(religion);
         
         String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
         religionBox = new JComboBox(valReligion); 
         religionBox.setBounds(270, 140, 370, 30);
         religionBox.setBackground(Color.WHITE);
         add(religionBox);
         
         JLabel category = new JLabel("Category : ");
         category.setFont(new Font("Raleway", Font.BOLD, 20));
         category.setBounds(100, 190, 200, 30);
         add(category);
         
         String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
         categoryBox = new JComboBox(valCategory); 
         categoryBox.setBounds(270, 190, 370, 30);
         categoryBox.setBackground(Color.WHITE);
         add(categoryBox);
         
         JLabel income = new JLabel("Income : ");
         income.setFont(new Font("Raleway", Font.BOLD, 20));
         income.setBounds(100, 240, 200, 30);
         add(income);
         
         String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "<5,00,000", "Upto 10,00,000"};
         incomeBox = new JComboBox(valIncome); 
         incomeBox.setBounds(270, 240, 370, 30);
         incomeBox.setBackground(Color.WHITE);
         add(incomeBox);
         
         JLabel educational = new JLabel("Educational ");
         educational.setFont(new Font("Raleway", Font.BOLD, 20));
         educational.setBounds(100, 290, 200, 30);
         add(educational);
         
         JLabel qualification = new JLabel("Qualification : ");
         qualification.setFont(new Font("Raleway", Font.BOLD, 20));
         qualification.setBounds(100, 312, 200, 30);
         add(qualification);
         
         String valEducation[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
         educationBox = new JComboBox(valEducation); 
         educationBox.setBounds(270, 312, 370, 30);
         educationBox.setBackground(Color.WHITE);
         add(educationBox);
        
         JLabel occupation = new JLabel("Occupation : ");
         occupation.setFont(new Font("Raleway", Font.BOLD, 20));
         occupation.setBounds(100, 360, 200, 30);
         add(occupation);
         
         String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
         occupationBox = new JComboBox(valOccupation); 
         occupationBox.setBounds(270, 360, 370, 30);
         occupationBox.setBackground(Color.WHITE);
         add(occupationBox);
         
         JLabel pan_number = new JLabel("PAN Number : ");
         pan_number.setFont(new Font("Raleway", Font.BOLD, 20));
         pan_number.setBounds(100, 410, 200, 30);
         add(pan_number);
         
         pan_numberTextField = new JTextField();
         pan_numberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         pan_numberTextField.setBounds(270, 410, 370, 30);
         add(pan_numberTextField);
         
         JLabel aadhar_number = new JLabel("Aadhar Number : ");
         aadhar_number.setFont(new Font("Raleway", Font.BOLD, 20));
         aadhar_number.setBounds(100, 460, 200, 30);
         add(aadhar_number);
         
         aadhar_numberTextField = new JTextField();
         aadhar_numberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         aadhar_numberTextField.setBounds(270, 460, 370, 30);
         add(aadhar_numberTextField);
         
         JLabel senior_citizen = new JLabel("Senior Citizen : ");
         senior_citizen.setFont(new Font("Raleway", Font.BOLD, 20));
         senior_citizen.setBounds(100, 510, 200, 30);
         add(senior_citizen);
         
         syes = new JRadioButton("Yes");
         syes.setBounds(270, 507, 130,40);
         syes.setFont(new Font("Raleway", Font.BOLD, 18));
         syes.setBackground(Color.WHITE);
         add(syes);
         
         sno = new JRadioButton("No");
         sno.setBounds(450, 507, 130,40);
         sno.setFont(new Font("Raleway", Font.BOLD, 18));
         sno.setBackground(Color.WHITE);
         add(sno);
         
         ButtonGroup senior_citizenGroup = new ButtonGroup();
         senior_citizenGroup.add(sno);
         senior_citizenGroup.add(syes);
         
         JLabel exisiting_account = new JLabel("Exisiting Account: ");
         exisiting_account.setFont(new Font("Raleway", Font.BOLD, 20));
         exisiting_account.setBounds(100, 560, 200, 30);
         add(exisiting_account);
         
         eyes = new JRadioButton("Yes");
         eyes.setBounds(270, 557, 130,40);
         eyes.setFont(new Font("Raleway", Font.BOLD, 18));
         eyes.setBackground(Color.WHITE);
         add(eyes);
         
         eno = new JRadioButton("No");
         eno.setBounds(450, 557, 130,40);
         eno.setFont(new Font("Raleway", Font.BOLD, 18));
         eno.setBackground(Color.WHITE);
         add(eno);
         
         ButtonGroup exisiting_accountGroup = new ButtonGroup();
         exisiting_accountGroup.add(eno);
         exisiting_accountGroup.add(eyes);
         
         
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
        String areligionBox = (String)religionBox.getSelectedItem();
        String acategoryBox = (String)categoryBox.getSelectedItem();
        String aincomeBox = (String)incomeBox.getSelectedItem();
        String aeducationBox = (String)educationBox.getSelectedItem();
        String aoccupationBox = (String)occupationBox.getSelectedItem();        
       
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        
        
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()){
            existingAccount = "No";
        }
        
        String apan = pan_numberTextField.getText();
        String aadhar = aadhar_numberTextField.getText();
        try{
            if(apan.equals("")){
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            }else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            }else{
                Conn c = new Conn();
                String query = "Insert into signuptwo values('"+formno+ "', '"+areligionBox+ "', '"+acategoryBox+"', '"+aincomeBox+"', '"+aeducationBox+"', '"+aoccupationBox+"', '"+apan+"', '"+aadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                //signup3 Object
                setVisible(false);
                new SignUpThree(formno).setVisible(true); 
            }
        }catch(Exception e){
             System.out.println(e);
        }

    } 
   
    public static void main(String args[]) {
         new SignUpTwo("");
    }
}
