/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.model;
import P0022.control.Control;
import java.util.ArrayList;
public class ExperienceCandidate extends Candidates{
    private int ExpInYear;
    private String ProSkill;
    public ExperienceCandidate(ArrayList<Candidates> canList) {
        input(canList);
    }

    public ExperienceCandidate(int ExpInYear, String ProSkill, String ID, String firstName, String lastName, String birthDate, String address, String phone, String email, int candidateType) {
        super(ID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }
    @Override
    public void input(ArrayList<Candidates> canList){
        super.input(canList);
        Control control= new Control();
        super.setCandidateType(0);
        this.ExpInYear= control.getInputExpInYear();
        this.ProSkill= control.getInputString("Enter pro skill: ");
    }
}
