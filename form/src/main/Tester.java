/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import form.*;
import interfaceShape.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList shape= new ArrayList();
        while(true){
            System.out.print("Enter form (1-Circle, 2-Rectangle, 3-Triangle): ");
            int choose= sc.nextInt();
            if((choose<1)||(choose>3))
                break;
            switch (choose) {
                case 1: shape.add(new Circle());                    
                        break;
                case 2: shape.add(new Rectangle());                    
                        break;
                case 3: shape.add(new Triangle());                    
                        break;
                default:
                    break;
            }
        }
        double maxArea=0, minPer=100000;
        System.out.println("INFORMATION:");
        for(int i=0; i< shape.size(); i++){
            if(shape.get(i) instanceof Circle){
                if(maxArea<((Circle)shape.get(i)).are())
                    maxArea= ((Circle)shape.get(i)).are();
                if(minPer>((Circle)shape.get(i)).perimeter())
                    minPer= ((Circle)shape.get(i)).perimeter();
            }
            if(shape.get(i) instanceof Rectangle){
                if(maxArea<((Rectangle)shape.get(i)).are())
                    maxArea= ((Rectangle)shape.get(i)).are();
                if(minPer>((Rectangle)shape.get(i)).perimeter())
                    minPer= ((Rectangle)shape.get(i)).perimeter();
            }
            if(shape.get(i) instanceof Triangle){
                if(maxArea<((Triangle)shape.get(i)).are())
                    maxArea= ((Triangle)shape.get(i)).are();
                if(minPer>((Triangle)shape.get(i)).perimeter())
                    minPer= ((Triangle)shape.get(i)).perimeter();
            }
        }   
        for(int i=0; i< shape.size(); i++){
            if(shape.get(i) instanceof Circle)
                ((Circle)shape.get(i)).output();
            if(shape.get(i) instanceof Rectangle)
                ((Rectangle)shape.get(i)).output();
            if(shape.get(i) instanceof Triangle)
                ((Triangle)shape.get(i)).output();
        }   
        System.out.println("Max area: "+maxArea+". Min perimeter: "+minPer);
    }
}
