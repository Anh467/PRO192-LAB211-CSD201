/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055.model;

import java.util.Map;
import P0055.mannagment.Mannagement;

public class DOCTOR {
    private String Code, Name, Specialization;
    private int availability;

    public DOCTOR(Map<String, DOCTOR> doctorList) {
        input(doctorList);
    }

    public DOCTOR(String Code, String Name, String Specialization, int availability) {
        this.Code = Code;
        this.Name = Name;
        this.Specialization = Specialization;
        this.availability = availability;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    @Override
    public String toString() {
        
        return Code + "     " + Name + "          " + Specialization + "          " + availability;
    }
    public void viewInformation(){
        System.out.format("%-10s%-20s%-20s%-30s\n",Code, Name, Specialization, availability);
    }
    public void input(Map<String, DOCTOR> doctorList){
        Mannagement mage= new Mannagement();
        this.Code= mage.getInputCode("Enter code: ", doctorList);
        this.Name= mage.getInputString("Enter name: ");
        this.Specialization= mage.getInputString("Enter Specialization: ");
        this.availability= mage.getInputInt("Enter availability: ");
        System.out.println("!!!ADD SUCCESSFULL!!!");
    }
}
