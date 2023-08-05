
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class demo extends JFrame implements ActionListener {

    private final JTextField nameTextField;

    demo() {
        setLayout(null);
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setBounds(270, 140, 370, 30);
//        nameTextField.addActionListener(this); // Add ActionListener here
        addAutoCapitalization(nameTextField);
        add(nameTextField);

        setLayout(null);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

//    public void actionPerformed(ActionEvent ae) {
//        capitalizeFirstWord(nameTextField);
//        String name = nameTextField.getText();
//    }

    private void capitalizeFirstWord(JTextField textField) {
        String text = textField.getText().trim();
        if (!text.isEmpty()) {
            // Convert the first word to uppercase
            String firstWordUpperCase = text.substring(0, 1).toUpperCase() + text.substring(1);
            System.out.println(firstWordUpperCase);
            textField.setText(firstWordUpperCase);
        }
    }
    
    
    private void addAutoCapitalization(JTextField textField2) {
        textField2.getDocument().addDocumentListener(new DocumentListener() {
       
            @Override
            public void insertUpdate(DocumentEvent e) {
                capitalizeFirstWord(textField2);
            }

            
            @Override
            public void removeUpdate(DocumentEvent e) {
                capitalizeFirstWord(textField2);
            }

         
            @Override
            public void changedUpdate(DocumentEvent e) {
                capitalizeFirstWord(textField2);
            }
        });
    }

    public static void main(String args[]) {
        new demo();
    }
}
