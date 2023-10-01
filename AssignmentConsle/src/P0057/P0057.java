/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0057;
import RunProGram.MainJFrameProgram;
import resource.*;
import validation.*;
import Control.*;
import mannger.*;
public class P0057 {
    public static void main(String[] args) {
        int choice;
        String[] option= {"USER MANAGEMENT SYSTEM", "Create a new account", "Login system", "Exit"};
        MainJFrameProgram newFrame;
        mannageAcount mannage= new mannageAcount();
        mannage.getData();
        do {            
            Control.menu(option);
            choice= Control.getChoice();
            switch (choice) {
                case 1: mannage.createNewAcount();
                    break;
                case 2: if(mannage.login()){
                            System.out.println("!!!Login successfull!!!");
                            newFrame= new MainJFrameProgram();
                            newFrame.setVisible(true);
                        }else
                        System.err.println("MAYBE UR USERNAME OR PASSWORD WRONG");
                case 3:
                    break;
            }
        } while (choice!=3);
        mannage.saveData();
    }
}
