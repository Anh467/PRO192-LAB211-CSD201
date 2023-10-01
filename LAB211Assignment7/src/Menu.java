package j1.s.p0074;
import java.util.Scanner;

public class Menu {
    public static void printMenu(String title, String[]menu){
        System.out.println("--------------------"+title+"--------------------");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i+1)+". "+menu[i]);
        }
        System.out.println((menu.length+1)+". Exit");

        System.out.print("(Please choose ");
        for (int i = 0; i < menu.length-1; i++) {
            System.out.print((i+1)+" to "+menu[i]+", ");
        }
        System.out.print((menu.length)+" to "+menu[menu.length-1]+" ");
        System.out.println("and "+(menu.length+1)+" to Exit program).");
    }
    public static int menu(String title,String [] menu){
        while (true) {            
            try {
                printMenu(title,menu);
                Scanner sc= new Scanner(System.in);
                int choose=Integer.parseInt(sc.nextLine());
                if (choose<1 || choose>menu.length+1) throw new Exception("Not have this choose");
                return choose;
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
