/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;


import DataAccessLayer.DataAccessSC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amese
 */
public class BL_SC {
     public List <StudentCourse> ls = new ArrayList<StudentCourse>();
    ResultSet rs;
    
    DataAccessSC ds = new DataAccessSC();
   
   public List<StudentCourse>fetch() throws SQLException {
    
     try {
        rs= ds.readTable();
        while (rs.next())
        {

                int id = rs.getInt("student_id");
                String n = rs.getString("CourseCode");
                String sn = rs.getString("StudentName");
                String em = rs.getString("StudentSurname");
               
                
            
                
            ls.add(new StudentCourse(id,n,sn,em));
                
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
     
   public int courseEnroll(StudentCourse stc) {
   int rowInserted =0;
        
        rowInserted = ds.studentCourse(stc);

    return rowInserted;
    }
       
   
   public int DeleteRecord(StudentCourse stc) {
    int rowsUpdated = 0;
    int id = stc.getId();
   
    
        rowsUpdated = ds.DeleteRecord(id) ;

    return rowsUpdated;
   }
}
