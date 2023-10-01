/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021.model;

/**
 *
 * @author 84384
 */
public class Report {
    private String ID, name, courseName;

    public Report(String ID, String name, String courseName) {
        this.ID = ID;
        this.name = name;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return ID + " | " + name + " | " + courseName;
    }
    
}
