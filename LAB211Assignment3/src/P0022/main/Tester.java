/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.main;
import P0022.control.Control;
import P0022.model.*;
import java.util.ArrayList;
public class Tester {
    public static void main(String[] args) {
        ArrayList<Candidates> canList= new ArrayList<>();
        Control control= new Control();
        canList.add(new ExperienceCandidate(3, "hack", "DE160170", "Nguyen Anh", "Viet", "23/04/2002", "Quang Ngai", "0384859541", "viet@fpt.edu.vn", 0));
        String[] option={"CANDIDATE MANAGEMENT SYSTEM", "Experience", "Fresher ", "Internship", "Searching","Exit"," (Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, \n3 to Internship Candidate, 4 to Searching and 5 to Exit program)."};
        int choice;
        do {            
            control.mainScreen(option);
            choice= control.getChocie();
            switch (choice) {
                case 1: canList.add(new ExperienceCandidate(canList));
                    break;
                case 2: canList.add(new FresherCandidate(canList));
                    break;
                case 3: canList.add(new InternCandidate(canList));
                    break;
                case 4: control.searchFunction(canList);
                    break;
                default:
                    break;
            }
        } while (choice!=5);
    }
}
