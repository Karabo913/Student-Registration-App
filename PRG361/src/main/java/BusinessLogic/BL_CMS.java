/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import DataAccessLayer.DataAccess;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author amese
 */
public class BL_CMS {
    public List <courses> ls = new ArrayList<courses>();
    ResultSet rs;
    
    DataAccess ds = new DataAccess();
    
   public List<courses>fetch() throws SQLException {
    
     try {
        rs= ds.readTable();
        while (rs.next())
        {

                int id = rs.getInt("id");
                String cn = rs.getString("courseName");
                String cc = rs.getString("code");
                String l = rs.getString("lecture");
                Date sd = rs.getDate("startDate");
                Date ed = rs.getDate("endDate");
                
            String startDateStr = (sd != null) ? new SimpleDateFormat("yyyy-MM-dd").format(sd) : null;
            String endDateStr = (ed != null) ? new SimpleDateFormat("yyyy-MM-dd").format(ed) : null;
                
            ls.add(new courses(id,cn,cc,l,startDateStr,endDateStr));
                
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
    
    public int insertCourse(courses course) {
   int rowInserted =0;
        
        rowInserted = ds.insertCourses(course);

    return rowInserted;
    }
    
public int updateCourse(courses course) {
    int rowsUpdated = 0;

    int id = course.getId();
    String updatedCourseName =course.getCourseName();
    String updatedCourseCode = course.getCourseCode();
    String updatedLecture = course.getLecture() ;
    String updatedStartDate = course.getStartDate();
    String updatedEndDate = course.getEndDate();
        

   
   
        
        rowsUpdated = ds.updateeCourse(id, updatedCourseName, updatedCourseCode, updatedLecture, updatedStartDate, updatedEndDate);

    return rowsUpdated;
}

   public int DeleteCourse(courses course) {
    int rowsUpdated = 0;
    int id = course.getId();
   
    
        rowsUpdated = ds.DeleteCourse(id) ;

    return rowsUpdated;
   }
}

    



