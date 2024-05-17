//database connnectivity 
//step1: register the driver
//step2: create connection
//step3: create statement
//step4: execute query
//step5 : close connection
package bank.management.system;

import java.sql.*;

 
public class conn {
    Connection c;   //create connection
    Statement s;   //create statement
    public conn()
    {
        try{
        
        c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","aayush2003");
        s=c.createStatement();
    }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    
}
