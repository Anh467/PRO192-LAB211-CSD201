/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question6;

import java.util.Scanner;
import question8.infixToPrefix;

/**
 *
 * @author 84384
 */
public class Implement {
    public static void main(String[] args) {
        infixToPrefix control= new infixToPrefix();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter your content: ");
        String str= sc.nextLine();
        str= str.replaceAll(" ", "");
        if(!control.checkValid(str))
            System.out.println("Wrong parentheses format");
        else System.out.println(control.infixToPrefix(str));
    }
}
