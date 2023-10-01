
package lab;

import java.util.Scanner;

public class Lesson5 {
    static Scanner ip= new Scanner(System.in);
    static int getUserChoice(){
        int choice;
        System.out.format("\n----------------------------\n");
        System.out.println("Enter 1 to active func 1");
        System.out.println("Enter 1 to active func 2");
        System.out.println("Enter 1 to active func 3");
        System.out.println("Enter 1 to active func 4");
        System.out.print("choose: ");
        choice= ip.nextInt();
        return choice;
    }
    public static void main(String[] args) {
        Lesson1 func1= new Lesson1();
        Lesson2 func2= new Lesson2();
        Lesson3 func3= new Lesson3();
        Lesson4 func4= new Lesson4();
        int getChoice;
        do{
            getChoice= getUserChoice();
            switch(getChoice){
                case 1: func1.main(args);
                        break;
                case 2: func2.main(args);
                        break;
                case 3: func3.main(args);
                       break;
                case 4: func4.main(args);
                        break;
                default: System.out.println("byte");
            }
        }while(getChoice>0&&getChoice<=4);
    }
}
