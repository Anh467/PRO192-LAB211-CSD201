
package lab;

import java.util.Scanner;
import java.lang.Math;

public class Lesson2 {
    public static void main(String[] args) {
        float a, b;
        Scanner ip= new Scanner(System.in);
        do{
            System.out.print("Enter first side of a rectangle: ");
            a= ip.nextFloat();
            if(a<=0)
                System.out.println("You can't access number less or equal 0");
        }
        while(a<=0);
        do{
            System.out.print("Enter second side of a rectangle: ");
            b= ip.nextFloat();
            if(b<=0)
                System.out.println("You can't access number less or equal 0");
        }
        while(b<=0);
        System.out.println("Perimeter  : "+(2*(a+b)));
        System.out.println("Area       : "+(a*b));
        System.out.println("Minor sides: "+(Math.sqrt(a*a+b*b)));
    }
}
