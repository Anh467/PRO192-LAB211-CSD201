/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84384
 */
public class StudentBiz extends Student {
    

    public StudentBiz() {
    }

//construct
    public StudentBiz(String ID, String name, String address, String email, double mark1, double mark2) {
        super(ID, name, address, email, mark1, mark2);
    }


    @Override
    public double ave() {
        return (2*super.getMark1()+super.getMark2())/3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
