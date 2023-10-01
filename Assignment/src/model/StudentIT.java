/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JTextField;

/**
 *
 * @author 84384
 */
public class StudentIT extends Student {
    
    

//construct
    public StudentIT() {
    }
    public StudentIT(String ID, String name, String address, String email, double mark1, double mark2) {
        super(ID, name, address, email, mark1, mark2);
    }



    @Override
    public double ave() {
        return (3*super.getMark1()+super.getMark2())/4;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
