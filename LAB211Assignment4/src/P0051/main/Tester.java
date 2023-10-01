/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051.main;

/**
 *
 * @author 84384
 */import P0051.function.Function;
import P0051.control.Control;
public class Tester {
    public static void main(String[] args) {
        Function func= new Function();
        String[] option= {"======== CALCULATOR PROGRAM ========","Normal calculator","BMI calculator","Exit"} ;
        Control control= new Control();
        int choice;
        do {            
            control.mainScreen(option);
            choice= control.getInput();
            switch (choice) {
                case 1:System.out.println("------- Normal Calculator -------");
                        System.out.println("result: "+func.NormalCalculator());
                    break;
                case 2:System.out.println("------- BMI Calculator -------");
                        System.out.println("BMI status: "+func.BMICalculator());
                    break;
                case 3: 
                    break;
            }
        } while (choice!=3);
    }
}
