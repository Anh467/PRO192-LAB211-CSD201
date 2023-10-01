/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0001.view;
import java.util.ArrayList;
import java.util.Scanner;
import P0001.control.Control;
public class Implement {
    public static void action(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of array:");
        while(true){
            try {
                
                Control.randNum(sc.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("Inappropriate input, try again:");
                System.out.println("Enter number of array:");
                sc.nextLine();
            }
        }
        System.out.print("Unsorted array: [");
        Control.view();
        Control.sortBuble();
        System.out.print("Sorted array  : [");
        Control.view();
    }
}
