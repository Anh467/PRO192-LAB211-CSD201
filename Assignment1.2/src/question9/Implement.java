/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question9;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Implement {
    public static void main(String[] args) {
        EvauluePostfix control= new EvauluePostfix();
        Scanner sc= new Scanner(System.in);
        String str;
        while (true) {            
            System.out.print("Enter your content: ");
            str= sc.nextLine().trim();
            str= str.replaceAll(" ", "");
            if(control.CheckPostfix(str))
                break;
             System.out.println("Wrong format profix");
        }
        System.out.println("result: "+control.CalculatePostfix(str));
    }
}
