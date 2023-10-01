
package lab;

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        Scanner ip= new Scanner(System.in);
        float number_elec;
        System.out.print("Enter number of electricity used: ");
        number_elec= ip.nextFloat();
        if((number_elec<=50)&& (number_elec>= 0))
            System.out.print("the price for each excess number of electricity is: "+(number_elec*1000));
            else if (number_elec> 50)
                    System.out.print("the price for each excess number of electricity is: "+(number_elec*1200));
    }
}
