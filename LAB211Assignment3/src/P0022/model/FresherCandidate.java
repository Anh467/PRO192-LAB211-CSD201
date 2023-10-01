/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.model;
import P0022.control.Control;
import java.util.ArrayList;
public class FresherCandidate extends Candidates{
    private String Graduation_date, Graduation_rank, Education;

    public FresherCandidate(ArrayList<Candidates> canList) {
        input(canList);
    }

    public FresherCandidate(String Graduation_date, String Graduation_rank, String Education, String ID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType) {
        super(ID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.Graduation_date = Graduation_date;
        this.Graduation_rank = Graduation_rank;
        this.Education = Education;
    }

    public String getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(String Graduation_date) {
        this.Graduation_date = Graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String Graduation_rank) {
        this.Graduation_rank = Graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }
    @Override
    public void input(ArrayList<Candidates> canList){
        Control control= new Control();
        super.input(canList);
        super.setCandidateType(1);
        this.Education= control.getInputString("Enter education: ");
        this.Graduation_date= control.getInputDate("graduation date");
        this.Graduation_rank= control.getInputGraduation_rank();
    }
}
