/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;


import DataAccessLayer.DataAccessStudent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amese
 */
public class BL_Student {
     public List <student> ls = new ArrayList<student>();
    ResultSet rs;
    
    DataAccessStudent ds = new DataAccessStudent();
   // Method 1
   public List<student>fetch() throws SQLException {
    
     try {
        rs= ds.readTable();
        while (rs.next())
        {

                int id = rs.getInt("id");
                String n = rs.getString("Name");
                String sn = rs.getString("Surname");
                String em = rs.getString("Email");
                String gd = rs.getString("Gender");
                
            
                
            ls.add(new student(id,n,sn,em,gd));
                
        } 
     }finally {
                if(rs!=null){
                        try{
                         rs.close();
                            }catch(SQLException e)
                                    {
                                            e.printStackTrace();
                                    }        
                }
           
        
    }return ls;
    
    }
   // 2
   public int registerStudent(student stu) {
   int rowInserted =0;
        
        rowInserted = ds.CreateStudent(stu);

    return rowInserted;
    }
   //3
   public int updateCourse(student stu) {
    int rowsUpdated = 0;
    int id = stu.getId();
    String name= stu.getStuName();
    String surname = stu.getStuSurname();
    String email = stu.getStuEmail() ;
    String gender = stu.getGender();
    
        rowsUpdated = ds.UpdateStudent(id, name, surname, email, gender);

    return rowsUpdated;
   }
   
    public int DeleteStudent(student stu) {
    int rowsUpdated = 0;
    int id = stu.getId();
   
    
        rowsUpdated = ds.deleteStudent(id);

    return rowsUpdated;
   }
}
