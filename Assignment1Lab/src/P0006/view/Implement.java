/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0006.view;
import java.util.ArrayList;
import java.util.Scanner;
import P0006.control.Control;
public class Implement {
    public static void action(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of array:");
        //try catch kiem tra loi dong thoi nhap thong in so phan tu
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
        Control.sortBuble();

        //try catch kiem tra loi dong thoi nhap thong in so can tim
        System.out.println("Enter search vaule:");
        while(true){
            try {
                Control.binarySearch(sc.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("Inappropriate input, try again:");
                System.out.println("Enter number of array:");
                sc.nextLine();
            }
        } 
    }
}
