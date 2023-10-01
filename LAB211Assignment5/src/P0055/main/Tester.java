/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055.main;
import P0055.mannagment.*;
import P0055.control.Control;
import java.nio.file.Paths;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Mannagement mannage= new Mannagement();
        String[] option={"Doctor Management","Add Doctor","Update Doctor","Delete Doctor", "Search Doctor","Exit"};
        String path= Paths.get("").toAbsolutePath().toString();
        mannage.addListFromeFile(path+"/src/P0055/model/doctor.txt");
        int choice= 0;
        do{
            Scanner sc= new Scanner(System.in);
            Control.menu(option);
            choice= Control.getChoice();
            switch (choice) {
                case 1: System.out.println("------- ADD DOCTOR -------");
                        mannage.addDoctor();
                    break;
                case 2: System.out.println("------- UPDATE DOCTOR -------");
                        System.out.print("Enter code: ");
                        mannage.updateDoctor(sc.nextLine());
                        break;
                case 3: System.out.println("------- DELETE DOCTOR -------");
                        System.out.print("Enter code: ");
                        mannage.deleteDoctor(sc.nextLine());
                        break;
                case 4: System.out.println("-------- Search Doctor ---------");
                        System.out.print("Enter name: ");
                        mannage.searchDoctorInformation(sc.nextLine());
                        break;
                default:
                    throw new AssertionError();
            }
        }while(choice!=5);
    }
}
