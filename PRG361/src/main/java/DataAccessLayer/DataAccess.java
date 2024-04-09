/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import BusinessLogic.courses;
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
public class DataAccess implements ICourseDB{
 Connection conn = DatabaseConnections.getConnections();
    ResultSet rs;
    PreparedStatement pstmt;
     int rowsInserted ;
    @Override
    public ResultSet readTable() {
        try {
           
            String sql = "SELECT id, courseName, code, lecture, startDate, endDate FROM courses";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error");
        }return rs;
    }


    @Override
    public int insertCourses(courses course) {
  
    rowsInserted = 0;
    try {
        
        String sql_Insert = "INSERT INTO courses (courseName, code, lecture, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql_Insert);
        
       
        pstmt.setString(1, course.getCourseName());
        pstmt.setString(2, course.getCourseCode());
        pstmt.setString(3, course.getLecture());
        pstmt.setDate(4, java.sql.Date.valueOf(course.getStartDate()));
        pstmt.setDate(5, java.sql.Date.valueOf(course.getEndDate()));
        
        
        rowsInserted = pstmt.executeUpdate();
    } catch (SQLException ex) {
       
        Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
          
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
           
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    return rowsInserted;    }

    @Override
public int updateeCourse(int id, String updatedCourseName, String updatedCourseCode, String updatedLecture, String updatedStartDate, String updatedEndDate) {
    try {
        rowsInserted = 0;
        
        String sql_Update = "UPDATE `schoolapp`.`courses` SET `courseName` = ?, `code` = ?, `lecture` = ?, `startDate` = ?, `endDate` = ? WHERE (`id` = ?)";
        pstmt = conn.prepareStatement(sql_Update);
        
        pstmt.setString(1, updatedCourseName);
        pstmt.setString(2, updatedCourseCode);
        pstmt.setString(3, updatedLecture);
        pstmt.setString(4, updatedStartDate);
        pstmt.setString(5, updatedEndDate);
        pstmt.setInt(6, id);
        
        rowsInserted = pstmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rowsInserted;  
}


    @Override
    public int DeleteCourse(int studentId) {
            int rowsDeleted= 0;
    try {
         
         String sql = "DELETE FROM courses WHERE id = ?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, studentId);
         
         rowsDeleted = pstmt.executeUpdate();
         
         return rowsDeleted;
     } catch (SQLException ex) {
         Logger.getLogger(DataAccessStudent.class.getName()).log(Level.SEVERE, null, ex);
     } return rowsDeleted;
    }
    
    
}

  
    

