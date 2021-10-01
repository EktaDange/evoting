/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author ekta dange
 */
public class DBConnection {
    
    private static Connection conn;
    static
    {
        try
       {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-O4LJCOQ:1521/XE","evoting","evoting");
           System.out.println("connection done");
       }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
            
        }
       catch(SQLException e)
       
          {
           e.printStackTrace();
        } 
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            if(conn!=null)
                conn.close();
        }
        catch(SQLException sqex)
        {
            sqex.printStackTrace();
        }
    }
    
    
}
