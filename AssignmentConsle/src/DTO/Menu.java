/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Menu {
    public int get_user_choice(){
        System.out.print("Choice: ");
        Scanner sc= new Scanner(System.in);
        int choice= sc.nextInt();
        return choice;
    }
}
