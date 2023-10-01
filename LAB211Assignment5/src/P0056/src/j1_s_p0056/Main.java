package j1_s_p0056;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Worker> wk = new ArrayList<>();
        ArrayList<History> hs = new ArrayList<>();

        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addWorker(wk);
                    Read_Save_File.saveListIntoFile(wk);
                    System.out.println("Press enter to countinue.");
                    sc.nextLine();
                    break;
                case 2:
                    Read_Save_File.readFile(wk);
                    Manager.printListWorker(wk);
                    break;
                case 3:
                    Manager.UpSalary(wk, hs);
                    System.out.println("Press enter to countinue.");
                    sc.nextLine();
                    break;
                case 4:
                    Manager.DownSalary(wk, hs);
                    System.out.println("Press enter to countinue.");
                    sc.nextLine();
                    break;
                case 5:
                    Manager.printListHistory(hs);
                    System.out.println("Press enter to countinue.");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Exitt!! Bye...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter correct choice.");
            }
        }
    }
}
