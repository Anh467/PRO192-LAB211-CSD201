/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAN.DTO;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Menu {
     public static int getUserChoice(){
        Scanner sc= new Scanner(System.in);
        int choice;
        System.out.println("Press 1 to Create a Vase");
        System.out.println("Press 2 to Create a Statue");
        System.out.println("Press 1 to Create a Painting");
        System.out.println("Press 1 to Display the Item");
        System.out.print("choice: ");
        choice= sc.nextInt();
        return choice;
    }
}
