/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021.model;

import P0021.control.*;

/**
 *
 * @author 84384
 */
public class Student implements Comparable<Student>{
    private String ID, name, courseName;
    private int semester;

    public Student() {
    }

    public Student(String ID, String name, String courseName, int semester) {
        this.ID = ID;
        this.name = name;
        this.courseName = courseName;
        this.semester = semester;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return ID + " | " + name + " | " + courseName;
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
    
}
