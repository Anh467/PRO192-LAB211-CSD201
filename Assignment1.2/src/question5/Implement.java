/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question5;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Implement {
    public static void main(String[] args) {
        checkValid check= new checkValid();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter your content: ");
        String str= sc.nextLine();
        System.out.println("valid of string is "+check.checkValid(str));
    }
}
