/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.model;
import P0022.control.Control;
import java.util.ArrayList;
public class InternCandidate extends Candidates{
    private String Majors, Universityname;
    private int Semester;

    public InternCandidate(ArrayList<Candidates> canList) {
        input(canList);
    }

    public InternCandidate(String Majors, String Universityname, int Semester, String ID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType) {
        super(ID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.Majors = Majors;
        this.Universityname = Universityname;
        this.Semester = Semester;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String Majors) {
        this.Majors = Majors;
    }

    public String getUniversityname() {
        return Universityname;
    }

    public void setUniversityname(String Universityname) {
        this.Universityname = Universityname;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    @Override
    public void input(ArrayList<Candidates> canList){
        Control control= new Control();
        super.input(canList);
        super.setCandidateType(2);
        this.Majors= control.getInputString("Enter major: ");
        this.Universityname= control.getInputString("Enter name of university: ");
        this.Semester= control.getInputInt("semester");
    }
}
