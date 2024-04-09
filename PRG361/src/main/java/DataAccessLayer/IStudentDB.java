/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import java.sql.ResultSet;
import BusinessLogic.student;
/**
 *
 * @author amese
 */
public interface IStudentDB {
      ResultSet readTable();
      int CreateStudent(student stu);
      int UpdateStudent(int id, String name, String surname, String email, String gender);
      int deleteStudent(int studentId);
}
