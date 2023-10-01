
package Lab1b;

import java.util.Scanner;

public class GetUserChoice {
    public static int getUserChoice(){
    int choice;
    Scanner ip= new Scanner(System.in);
    System.out.println("--------------------------------------------------");
    System.out.println("Press 1 to enter name of student");
    System.out.println("Press 2 to enter mark");
    System.out.println("Press 3 to print out all information");
    System.out.println("Press 4 to sort according type");
    System.out.println("Press 5 to sort according mark");
    System.out.print("Choose: ");
    choice= ip.nextInt();
    return choice;
    }
}