/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059.main;
import P0059.control.Control;
import P0059.mannagement.Mannagement;
public class Tester {
    public static void main(String[] args) {
        //C:\Users\84384\Documents\NetBeansProjects\LAB211Assignment5\src\P0059\model\person.txt
        Mannagement manna= new Mannagement();
        String[] option={"File Processing ", "Find person info", "Copy Text to new file","Exit"};
        int choice= 0;
        do {            
            Control.menu(option);
            choice= Control.getChoice();
            switch (choice) {
                case 1: manna.readFile();
                        manna.disPlay();
                    break;
                case 2: manna.copyText();
                    break;
                default: break;
            }
        } while (choice!=3);
    }
}
