/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0062;
import P0062.Control;
import java.io.File;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("===== Analysis Path Program =====");
        System.out.println("Please input Path: ");
        Control.checkInputPath(sc.nextLine());
      
    }
}
