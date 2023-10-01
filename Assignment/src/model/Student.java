/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84384
 */
public abstract class Student {
    private String ID, name, address, email;
    private double mark1, mark2, ave;
//construct
    public Student() {
    }
    public Student(String ID, String name, String address, String email, double mark1, double mark2) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }
//get set
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }
//    this.ID = ID;
//        this.name = name;
//        this.address = address;
//        this.email = email;
//        this.mark1 = mark1;
//        this.mark2 = mark2;
    @Override
    public String toString() {
        return ID+"/"+name+"/"+address+"/"+email+"/"+mark1+"/"+mark2;
    }
    public abstract double ave();
}
