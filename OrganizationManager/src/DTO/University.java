/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 84384
 */
public class University extends Organization{
    private String name;
//construct
    public University() {
    }

    public University( int size, String name) {
        super(size);
        this.name = name;
    }
    
//overide
    @Override
    public void communicateByTool() {
        System.out.println("in the university, people communicate by voice");
    }
//gett setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//method
    public void enroll(){
        System.out.println("The registration for enrollment is only valid when the University has received all enrollment documents and enrollment fees");
    }
    public void educate(){
        System.out.println("“provide education at university standard");
    }
//to String

    @Override
    public String toString() {
        return "encourage the advancement and development of knowledge";
    }
    
}
