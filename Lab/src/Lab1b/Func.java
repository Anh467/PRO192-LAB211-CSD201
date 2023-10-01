
package Lab1b;

import java.util.Scanner;

public class Func {

    /**
     *
     * @return
     */
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
    public String addStudent(){
        String str;
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter student name: ");
        str= ip.nextLine();
        return str;
    }
    public double addMark(String str){
        double mark;
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter mark for "+str+": ");
        mark= ip.nextDouble();
        System.out.println("!!!successfull!!");
        return mark;
    }
    public String addType(double mark){
        if (mark< 5)
            return "Weak";
        else if(mark>= 5 && mark< 6.5)
            return "Average";
        else if(mark>= 6.5 && mark< 7.5)
            return "Good";
        else if(mark>= 7.5 && mark< 9)
            return "Excellent";
        else if(mark>=9)
            return "Excellent";
        return null;
    }
}
