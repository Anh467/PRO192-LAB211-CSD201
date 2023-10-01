/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author 84384
 */
public class Person implements Serializable{
    protected String person_name, person_address, person_birth;
    protected boolean person_gender;
//construct
    public Person() {

    } 
    public Person(String person_name, String person_address, String person_birth, boolean person_gender) {
        this.person_name = person_name;
        this.person_address = person_address;
        this.person_birth = person_birth;
        this.person_gender = person_gender;
    }
//get set
    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_address() {
        return person_address;
    }

    public void setPerson_address(String person_address) {
        this.person_address = person_address;
    }

    public String getPerson_birth() {
        return person_birth;
    }

    public void setPerson_birth(String person_birth) {
        this.person_birth = person_birth;
    }

    public boolean isPerson_gender() {
        return person_gender;
    }

    public void setPerson_gender(boolean person_gender) {
        this.person_gender = person_gender;
    }
//toString
    @Override
    public String toString() {
        return person_name + "/" + person_address + "/" + person_birth + "/" + person_gender;
    }
    
}
