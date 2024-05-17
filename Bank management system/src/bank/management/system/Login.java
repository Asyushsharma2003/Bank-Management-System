 
package bank.management.system;
import javax.swing.*;
import java.awt.*; // for Image  class
import java.awt.event.*;
import java.sql.*;
 

 
public class Login extends JFrame implements ActionListener{ //actionlistner for user actions
    //as ActionListener is interface so we have to override its methods
    //public void actionPerformed(ActionEvent e); (we have to override this)
    
    
    JButton  login,signup, clear; //defining globally
    JTextField cardTextField;
    JPasswordField pinTextField; // for hidding password
    

    Login()
    {
        setLayout(null); // it nullifies the default layout so we can place buttons,images at our decided destination
        setTitle("AUTOMATED TELLER MACHINE");  // adding title
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//gets image
        
        Image i2 = i1.getImage().getScaledInstance(100 , 100 , Image.SCALE_DEFAULT);//image adjustments
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3); // image is inserted as label on frame
        label1.setBounds(70 , 10 , 100 , 100);// image on frame adjustments
        add(label1); // adding label on frame
        setSize(800,400);// setting frame size
        setVisible(true); // setting frame visible to us ( bydefault : notvisible)
        setLocation(350, 200); // setting location of frame 
        
        
        getContentPane().setBackground(Color.WHITE); // for setting background color of frame
        
        // major use of jlabel is to write anything on frame
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward" ,  Font.BOLD , 38));
        text.setBounds(200 , 40 , 400 , 40);
        add(text); // right now it will not be visible as you have to set bounds of it
        
        // another label
          JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway" ,  Font.BOLD , 28));
        cardno.setBounds(120 , 150 , 150 , 40);
        add(cardno); // right now it will not be visible as you have to set bounds of it
        
        //now we want a box in which a user can enter his details
        
        //cardno input box
        
       cardTextField = new JTextField();
        cardTextField.setBounds(300 , 157 , 225 , 30);
        cardTextField.setFont(new Font("Arial" ,  Font.BOLD , 14));
        add(cardTextField);
        
        
        
        
        
        //another label
          JLabel pin = new JLabel("Pin:");
       pin.setFont(new Font("Raleway" ,  Font.BOLD , 28));
        pin.setBounds(120 , 220 , 400 , 40);
        add(pin); // right now it will not be visible as you have to set bounds of it
        
        
        // pin input box
            pinTextField = new JPasswordField();
        pinTextField.setBounds(300 , 227 , 225 , 30);
        pinTextField.setFont(new Font("Arial" ,  Font.BOLD , 14));
        add(pinTextField);
        
        //creating clear button
          clear = new JButton("CLEAR");
        clear.setBounds(300 , 300 ,100  , 30);
        clear.setBackground(Color.BLACK); // box colour
        clear.setForeground(Color.white); //  text color which  is inside box
        clear.addActionListener(this); // now action is ready to  be taken
        add(clear);
        
         //creating  SIGNIN button
          login= new JButton("LOGIN");
        login.setBounds(425 , 300 ,100  , 30);
        login.setBackground(Color.BLACK); // box colour
        login.setForeground(Color.white); //  text color which  is inside box
        login.addActionListener(this); // now action is ready to  be taken
        add(login);
        
        //creating  SIGNUP button
           signup= new JButton("SIGN UP");
        signup.setBounds(300 , 336 ,225 , 30);
        signup.setBackground(Color.BLACK); // box colour
        signup.setForeground(Color.white); //  text color which  is inside box
        signup.addActionListener(this); // now action is ready to  be taken
        add(signup);
        
        
         
        
    } // constructor ends
    public void actionPerformed(ActionEvent ae){
         
        //  here we have overriden method of interface ActionListener
        
        if(ae.getSource()== clear)
        {
            cardTextField.setText(""); // sets your text manually in textfield
            pinTextField.setText("");
        }
        else if(ae.getSource()== signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
            
            
        }
        else if(ae.getSource()== login)
        {
            conn c = new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            
            } else {
              JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
            }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            
            
        }
        
    }
    
    
    
    public static void main(String args[]) {
        new Login();
    }
}
