/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.model;
import P0022.control.Control;
import java.util.ArrayList;
public class Candidates {
    protected String ID, firstName, lastName, birthDate, address, phone, email;
    protected int candidateType;

    public Candidates() {
    }

    public Candidates(String ID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }
//String ID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType
    public void input(ArrayList<Candidates> canList){
        Control control= new Control();
        this.ID= control.getInputID(canList);
        this.firstName= control.getInputString("Enter first name: ");
        this.lastName= control.getInputString("Enter Last name: ");
        this.birthDate= control.getInputDate("birthdate");
        this.address= control.getInputString("Enter address: ");
        this.phone= control.getInputPhone();
        this.email= control.getInputEmail();
        
//this.candidateType= control.getInputCandidateType();
    }
    @Override
    public String toString() {
        return this.firstName+" "+this.lastName +" | " +this.address+" | "+this.phone+" | "+ this.candidateType;
    }
    
}
