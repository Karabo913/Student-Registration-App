/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

/**
 *
 * @author amese
 */
public class StudentCourse {

    
            int id ;
        String code ;
        String name ;
        String surname ;
    

            public StudentCourse(int id, String code, String name, String surname) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.surname = surname;
    }
            
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
