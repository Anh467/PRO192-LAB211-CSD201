/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0008.view;
import P0008.control.Control;
import P0008.model.Model;
import java.util.Scanner;
public class view {
    public static void action(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your content:");
        Control.count(sc.nextLine());
    }
}
