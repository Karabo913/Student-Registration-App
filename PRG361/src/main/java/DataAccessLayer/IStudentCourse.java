/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import BusinessLogic.StudentCourse;
import java.sql.ResultSet;

/**
 *
 * @author amese
 */
public interface IStudentCourse {
          ResultSet readTable();
      int studentCourse(StudentCourse stc );
      int DeleteRecord(int studentId);
}
