package bank.management.system;

import javax.swing.*;
import java.awt.*; // for Image  class
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{
 JButton deposit , fastcash , cashwithdrawl , ministatement,pinchange,balanceenquiry,exit;
 String pinnumber;
   FastCash(String pinnumber)
   {
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
        
        
        JLabel text = new JLabel("SELECT  WITHDRAWL  AMOUNT");
        
        text.setBounds(200 ,220 , 700 , 35);
        text.setFont(new Font("System" ,  Font.BOLD , 16));
        text.setForeground(Color.WHITE);
        label1.add(text); // right now it will not be visible as you have to set bounds of it
        
        deposit = new JButton("Rs 100");
        deposit.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        deposit.setBounds(170 , 322 , 150 , 26);
        deposit.addActionListener(this);
        label1.add(deposit);
        
        fastcash = new JButton("RS 500");
        fastcash.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        fastcash.setBounds(170 , 348 , 150 , 26);
        fastcash.addActionListener(this);
        label1.add(fastcash);
        
        cashwithdrawl = new JButton("Rs 1000");
        cashwithdrawl.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        cashwithdrawl.setBounds(350 , 322 , 150 , 26);
        cashwithdrawl.addActionListener(this);
        label1.add(cashwithdrawl);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        ministatement.setBounds(350 , 348 , 150 , 26);
        ministatement.addActionListener(this);
        label1.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        pinchange.setBounds(170 , 374 , 150 , 26);
        pinchange.addActionListener(this);
        label1.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        balanceenquiry.setBounds(350 , 374 , 150 , 26);
        balanceenquiry.addActionListener(this);
        label1.add(balanceenquiry);
        
        exit = new JButton("BACK");
        exit.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        exit.setBounds(260 , 400 , 150 , 26);
        exit.addActionListener(this);
        label1.add(exit);
        
        setUndecorated(true); //for removing white background from image
        
         
        setVisible(true); // setting frame visible to us ( bydefault : notvisible)
   }
   
   public void actionPerformed(ActionEvent ae){
          
           if(ae.getSource()==exit)
          {
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
          }
          else 
          {
             String amount=((JButton)ae.getSource()).getText().substring(3); //Rs 5000
             conn c= new conn();
             try
             {
                 
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance" );
                    return;
                }
                
                Date date = new Date();
                String query = "INSERT INTO bank VALUES('"+pinnumber+"', '"+date+"' , 'withdrawl' , '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Sucessfully" );
                
                
                
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }catch(Exception e)
             {
                 System.out.println(e);
                 
             }

           }
   }
    public static void main(String args[]) {
        new FastCash("");
        // TODO code application logic here
    }
}
