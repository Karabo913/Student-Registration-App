/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import BusinessLogic.courses;


import java.sql.ResultSet;


/**
 *
 * @author amese
 */
public interface ICourseDB {
   //CRUD
    ResultSet readTable();//
   int insertCourses(courses course);
   int updateeCourse(int id, String updatedCourseName, String updatedCourseCode, String updatedLecture, String updatedStartDate, String updatedEndDate);
   int DeleteCourse(int studentId);
}
