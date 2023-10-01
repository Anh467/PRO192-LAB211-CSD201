
package LAB1_C;

import java.util.Scanner;

public class Function {
    public static int getUserChoice(){
    int choice;  
    Scanner ip= new Scanner(System.in);
    System.out.println("--------------------------------------------------");
    System.out.println("Press 1 to enter full name:");
    System.out.println("Press 2 to enter electricity index");
    System.out.println("Press 3 to export data");
    System.out.println("Press 4 to calculate electricity bill");
    System.out.println("Press 5 to sort the list of households in ascending order by electricity index");
    System.out.print("Choose: ");
    choice= ip.nextInt();
    return choice;
    }
    public static String get_name(){
        Scanner ip= new Scanner(System.in);
        String str;
        System.out.print("enter full name: ");
        str= ip.nextLine();
        return str;
    }
    public static String get_index(){
        Scanner ip= new Scanner(System.in);
        String str;
        System.out.print("enter full name: ");
        str= ip.nextLine();
        return str;
    }
    public static double cal_bill(double index){
        if(index>=0&&index<51)
            return index*1.678;
        if(index>=51&&index<101)
            return index*1.734;
        if(index>=101&&index<201)
            return index*2.014;
        if(index>=201&&index<301)
            return index*2.536;
        if(index>=301&&index<401)
            return index*2.834;
        return index*2.927;
    }
}
