/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import mannger.Mannger;
import DTO.Menu;
public class Tester {
    public static void main(String[] args) {
        int choice;
        Mannger mannger= new Mannger();
        Menu menu= new Menu();
        do {            
            choice= menu.get_user_choice();
            switch(choice){
                case 1: mannger.insert();
                        break;
                case 2: mannger.view();
                        break;
                case 3: mannger.searchStudentAddress();
                        break;
                case 4: mannger.deleteStudentID();
                        break;
                case 5: mannger.updateStudent();
                        break;
                case 6: mannger.sortName();
                        break;
                case 7: mannger.listAve();
                        break;
                case 8: mannger.topStudent();
                        break;
                case 9: mannger.saveFile();
                        break;
                case 10:mannger.readFile();
                        break;
                default:System.out.println("exit");
                        break;
            }
        } while (choice>0&&choice<11);
    }
}
