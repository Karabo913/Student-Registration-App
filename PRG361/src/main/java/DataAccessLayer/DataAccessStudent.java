/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import BusinessLogic.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amese
 */
public class DataAccessStudent implements IStudentDB {
 Connection conn = DatabaseConnections.getConnections();
    ResultSet rs;
    PreparedStatement pstmt;
     int rowsInserted ;
    @Override
    public ResultSet readTable() {
                try {
           
            String sql = "SELECT id, Name, Surname, Email, Gender FROM studentinfo";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error");
        
    }return rs;
    
}

    

    @Override
    public int CreateStudent(student stu) {
     try {
         rowsInserted = 0;
         
     
         String sql_Insert = "INSERT INTO studentinfo (Name, Surname, Email, Gender) VALUES (?, ?, ?, ?)";

         pstmt = conn.prepareStatement(sql_Insert);
         
        
         pstmt.setString(1, stu.getStuName());
         pstmt.setString(2, stu.getStuSurname());
         pstmt.setString(3, stu.getStuEmail());
         pstmt.setString(4,stu.getGender());
         
         
        
         rowsInserted = pstmt.executeUpdate();
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(DataAccessStudent.class.getName()).log(Level.SEVERE, null, ex);
     }return rowsInserted;
    }




    

    @Override
public int  deleteStudent(int studentId) {
     int rowsDeleted= 0;
    try {
         
         String sql = "DELETE FROM studentinfo WHERE id = ?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, studentId);
         
         rowsDeleted = pstmt.executeUpdate();
         
         return rowsDeleted;
     } catch (SQLException ex) {
         Logger.getLogger(DataAccessStudent.class.getName()).log(Level.SEVERE, null, ex);
     } return rowsDeleted;
    }

   @Override
public int UpdateStudent(int id, String name, String surname, String email, String gender) {
    int rowsUpdated = 0;
    try {
        StringBuilder sql_Update = new StringBuilder("UPDATE studentinfo SET");
        List<Object> params = new ArrayList<>();

        if (name != null) {
            sql_Update.append(" Name = ?,");
            params.add(name);
        }
        if (surname != null) {
            sql_Update.append(" Surname = ?,");
            params.add(surname);
        }
        if (email != null) {
            sql_Update.append(" Email = ?,");
            params.add(email);
        }
        if (gender != null) {
            sql_Update.append(" Gender = ?,");
            params.add(gender);
        }

      
        sql_Update.setLength(sql_Update.length() - 1);

      
        sql_Update.append(" WHERE id = ?");
        params.add(id);

        pstmt = conn.prepareStatement(sql_Update.toString());

      
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }

        rowsUpdated = pstmt.executeUpdate();

    } catch (SQLException ex) {
        Logger.getLogger(DataAccessStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rowsUpdated;
}


}

