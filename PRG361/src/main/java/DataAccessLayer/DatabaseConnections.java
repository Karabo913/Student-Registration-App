/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author amese
 */
public class DatabaseConnections {
    public static Connection getConnections (){
         Connection connection = null;
        try {       
            String url="jdbc:mysql://localhost:3307/schoolapp";
            String username = "root";
            String password = "Mkn22@1903#";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connnected to the database ");
        } catch (SQLException e) {
            System.err.println(" Connection error"+ e.getMessage());
        }
        
        return connection;
    }
}
    
