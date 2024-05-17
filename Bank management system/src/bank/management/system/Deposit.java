 
package bank.management.system;

import javax.swing.*;
import java.awt.*; // for Image  class
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit , back;
    String pinnumber;
    Deposit(String pinnumber) {
     this.pinnumber = pinnumber;
     setLayout(null);
     setSize(900,700);// setting frame size
     setLocation(300, 0); // setting location of frame 
     getContentPane().setBackground(Color.WHITE);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));//gets image
       
     Image i2 = i1.getImage().getScaledInstance(900 , 700 , Image.SCALE_DEFAULT);//image adjustments
     ImageIcon i3 = new ImageIcon(i2);
     JLabel label1 = new JLabel(i3); // image is inserted as label on frame
     label1.setBounds(0 , 0 , 900 , 700);// image on frame adjustments
     add(label1); // adding label on frame
     
     
   
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200 ,220 , 700 , 35);
        text.setFont(new Font("System" ,  Font.BOLD , 16));
        text.setForeground(Color.WHITE);
        label1.add(text); // right now it will not be visible as you have to set bounds of it
        
        amount = new JTextField();
        amount.setBounds(180 ,270 , 320 , 25);
        amount.setFont(new Font("Raleway " ,  Font.BOLD , 22));
        label1.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        deposit.setBounds(350 , 373 , 150 , 26);;
        deposit.addActionListener(this);
        label1.add(deposit);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        back.setBounds(350 , 401 , 150 , 26);;
        back.addActionListener(this);
        label1.add(back);
        
     
     
    setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==deposit)
          {
               String number = amount.getText();
               Date date = new Date();
               
               if(number.equals(""))
               {
                   JOptionPane.showMessageDialog(null , "Please enter the amount you want to deposit");
               } else{
                   try{
               
                    conn c = new conn();
                    String query = "INSERT INTO bank VALUES('"+pinnumber+"', '"+date+"' , 'Deposit' , '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully" );
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true); 
                      }
               
                catch(Exception e)
                    {
                      System.out.println(e);
                     }
          }}
          else if(ae.getSource()==back)
          {
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          }
   }
    public static void main(String args[]) {
       new Deposit("");
    }
}
