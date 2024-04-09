/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

/**
 *
 * @author amese
 */
public class courses {

  
    int id;
    String courseName;
     String courseCode;
     String Lecture;
     String StartDate;
     String EndDate;

    public courses(int id, String courseName, String courseCode, String Lecture, String StartDate, String EndDate) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.Lecture = Lecture;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }
     
  public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getLecture() {
        return Lecture;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }
}
