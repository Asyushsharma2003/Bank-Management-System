 
package bank.management.system;

 
 
import javax.swing.*;
import java.awt.*; // for Image  class
import java.awt.event.*;

 
  // for importing calender in DOB

 
public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField      pan , adhar ,stateTextField , pinTextField;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
     
    JComboBox religion,education,occupation,income,category;
    String formno;
    public SignupTwo(String formno)
        {
            this.formno = formno;
        
        setLayout(null); // now setbounds will gonna work
        setTitle("NEW ACCOUNT APPLICATION FOROM - PAGE 2");  // adding title
        
        
        //generating 4 digit positive random number
 
        
        setSize(850,800);// setting frame size
        setVisible(true); // setting frame visible to us ( bydefault : notvisible)
        setLocation(350, 10); // setting location of frame 
        
        getContentPane().setBackground(Color.WHITE); // for setting background color of frame
       
        
     
            
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway" ,  Font.BOLD , 22));
        additionaldetails.setBounds(290 ,80 , 400 , 30);
        add(additionaldetails); // right now it will not be visible as you have to set bounds of it
        
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        name.setBounds(100 ,140 , 100 , 30);
        add(name); // right now it will not be visible as you have to set bounds of it
        
        String valreligion[]={"Hindu" , "Muslim" , "Sikh","Christian","other"};
        
       religion=new JComboBox(valreligion);
       religion.setBounds(300 ,140 , 400 , 30);
       religion.setBackground(Color.WHITE);;
        add(religion);
        
     
        
         
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        fname.setBounds(100 ,190 , 200 , 30);
        add(fname); // right now it will not be visible as you have to set bounds of it
            
         String valcategory[]={"General" , "OBC" , "SC","ST","Other"};
       category=new JComboBox(valcategory);
       category.setBounds(300 , 190 , 400 , 30);
       category.setBackground(Color.WHITE);;
        add(category);
        
        
        
        
        JLabel dob = new JLabel("Income:");
         dob.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        dob.setBounds(100 ,240 , 200 , 30);
        add(dob); // right now it will not be visible as you have to set bounds of 
        
        String valincome[]={"Null" , " < 1,50,000" , " < 2,50,000"," <5,00,000","upto 10,00,000"};
       income=new JComboBox(valincome);
       income.setBounds(300 , 240 , 400 , 30);
       income.setBackground(Color.WHITE);;
        add(income);
        
        
         
        
        
        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        gender.setBounds(100 ,290 , 200 , 30);
        add(gender); // right now it will not be visible as you have to set bounds of it
        
        
        
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        email.setBounds(100 ,310 , 200 , 30);
        add(email); // right now it will not be visible as you have to set bounds of it
        
         String educationvalues[]={"Non-Graduation" , "Graduate" , "Post-Graduation","Doctrate","others"};
       education=new JComboBox(educationvalues);
       education.setBounds(300 , 315 , 400 , 30);
       education.setBackground(Color.WHITE);;
        add(education);
        
        
       String occupationvalues[]={"Salaried" , "Self-Employed" , "Bussiness","Student","Retire","other"};
       occupation=new JComboBox(occupationvalues);
       occupation.setBounds(300 , 390 , 400 , 30);
       occupation.setBackground(Color.WHITE);;
       add(occupation);
        
        
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        marital.setBounds(100 ,390 , 200 , 30);
        add(marital); // right now it will not be visible as you have to set bounds of it
        
        
      
      
        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        address.setBounds(100 ,440 , 200 , 30);
        add( address); // right now it will not be visible as you have to set bounds of it
        
        pan = new JTextField();
        pan.setBounds(300 , 440 , 400 , 30);
        pan.setFont(new Font("Raleway " ,  Font.BOLD , 14));
        add(pan);
        
        
        
        JLabel adharnumber = new JLabel(" Aadhar Number:");
        adharnumber.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        adharnumber.setBounds(100 ,490 , 200 , 30);
        add(adharnumber); // right now it will not be visible as you have to set bounds of it
        
        adhar = new JTextField();
        adhar.setBounds(300 , 490 , 400 , 30);
        adhar.setFont(new Font("Raleway " ,  Font.BOLD , 14));
        add(adhar);
        
        JLabel state = new JLabel(" Senior Citizen:");
        state.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        state.setBounds(100 ,540 , 200 , 30);
        add(state); // right now it will not be visible as you have to set bounds of it
        
       syes = new JRadioButton("Yes");
        syes.setBounds(300 ,540,100,30 );
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450 ,540,100,30 );
         sno.setBackground(Color.WHITE);
        add(sno);
        
        
        
        ButtonGroup martialstatus= new ButtonGroup();
        martialstatus.add(syes);
       martialstatus.add(sno);
       
        
         JLabel existing = new JLabel(" Existing Account:");
        existing.setFont(new Font("Raleway" ,  Font.BOLD , 20));
        existing.setBounds(100 ,590 , 200 , 30);
        add(existing); // right now it will not be visible as you have to set bounds of it
        
       eyes = new JRadioButton("Yes");
        eyes.setBounds(300 ,590,100,30 );
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450 ,590,100,30 );
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        
        ButtonGroup existingstatus= new ButtonGroup();
        existingstatus.add(eyes);
       existingstatus.add(eno);
       
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway" ,  Font.BOLD , 14));
        next.setBounds(620 , 640 , 80 , 30);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        
    }
        public void actionPerformed(ActionEvent ae){
            
            String sreligion= (String)religion.getSelectedItem();
            String scategory= (String)category.getSelectedItem();
            String sincome = (String)income.getSelectedItem();
            String seducation = (String)education.getSelectedItem();
            String soccupation = (String)occupation.getSelectedItem();
            String seniorcitizen = null;
            if(syes.isSelected())
            {
               seniorcitizen="Yes";
            }else if(sno.isSelected())
            {
            seniorcitizen="no";
            }
             
            String  sexisting= null;
            if(eyes.isSelected())
            {
              sexisting= "Yes";         
            }
            else if(eno.isSelected())
            {
              sexisting= "NO";         
            }
           
            
            String span = pan.getText();
            String saadhar = adhar.getText();
          
             
            try{
                 
                     conn c = new conn();
                     String query = "INSERT INTO signuptwo VALUES('"+formno+"', '"+sreligion+"' , '"+scategory+"' , '"+seducation+"','"+sincome+"' , '"+soccupation+"','"+span+"','"+saadhar+"' ,'"+sexisting+"','"+seniorcitizen+"' )";
                     c.s.executeUpdate(query);
                     
                     setVisible(false);
                     new signup3(formno).setVisible(true);
                     
                     //signup object
                     
                 
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
               
            
            
            
        }
        
    

    
    public static void main(String args[]) {
        new SignupTwo("");
         
    }
}