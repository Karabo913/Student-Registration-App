/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import BusinessLogic.StudentCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amese
 */
public class DataAccessSC implements IStudentCourse {

Connection conn = DatabaseConnections.getConnections();
    ResultSet rs;
    PreparedStatement pstmt;
     int rowsInserted ;
    @Override
    public ResultSet readTable() {
                try {
           
            String sql = "SELECT student_id, CourseCode, StudentName, StudentSurname FROM studentcourse";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error");
        
    }return rs;
    }
    
    @Override
   public int studentCourse(StudentCourse stc) {
  
    try {
        rowsInserted = 0;
        
       
        String sql_Insert = "INSERT INTO studentcourse (CourseCode, StudentName, StudentSurname) VALUES (?, ?, ?)";
        
        pstmt = conn.prepareStatement(sql_Insert);
        
        
        pstmt.setString(1, stc.getCode());
        pstmt.setString(2, stc.getName());
        pstmt.setString(3, stc.getSurname());
        
        
        
        
        rowsInserted = pstmt.executeUpdate();
        
        

       
    } catch (SQLException ex) {
        Logger.getLogger(DataAccessSC.class.getName()).log(Level.SEVERE, null, ex);
    } return rowsInserted;
    }

    @Override
    public int DeleteRecord(int studentId) {
             int rowsDeleted= 0;
    try {
         
         String sql = "DELETE FROM studentcourse WHERE student_id = ?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, studentId);
         
         rowsDeleted = pstmt.executeUpdate();
         
         return rowsDeleted;
     } catch (SQLException ex) {
         Logger.getLogger(DataAccessStudent.class.getName()).log(Level.SEVERE, null, ex);
     } return rowsDeleted;
    }
}
    

