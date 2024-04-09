/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

/**
 *
 * @author amese
 */
public class student {
    int id;
    String StuName;
    String StuSurname;
    String StuEmail;
    String Gender;

    public student(int id, String StuName, String StuSurname, String StuEmail, String Gender) {
        this.id = id;
        this.StuName = StuName;
        this.StuSurname = StuSurname;
        this.StuEmail = StuEmail;
        this.Gender = Gender;
    }



  
    public int getId() {
        return id;
    }

    public String getStuName() {
        return StuName;
    }

    public String getStuSurname() {
        return StuSurname;
    }

    public String getStuEmail() {
        return StuEmail;
    }

    public String getGender() {
        return Gender;
    }


}
