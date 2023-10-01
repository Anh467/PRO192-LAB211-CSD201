/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0050.main;

import P0050.mannagement.*;
import P0050.model.*;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Mannagement view= new Mannagement();
        String[] option= {"Calculate superlavtive", "Calculate quardratic equation","exit"};
        int choose;
        LinearEquation equation;
        do{
            view.mainScreen(option);
            choose= view.getInput();
            switch (choose) {
                case 1: equation= new LinearEquation();
                        equation.input();
                        System.out.println(equation.toString());
                    break;
                case 2: equation= new QuadraticEquation();
                        ((QuadraticEquation) equation).input();
                        System.out.println(((QuadraticEquation) equation).toString());
                    break;
                case 3: break;
            }
        }while(choose!=3);
    }
}
