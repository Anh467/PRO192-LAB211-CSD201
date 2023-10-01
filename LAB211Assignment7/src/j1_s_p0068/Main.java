package j1_s_p0068;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> st = new ArrayList<>();
        Read_Save_File.readFile(st);
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addStudent(st);
                    break;
                case 2:
                    Manager.printStudent(st);
                    break;
                case 3:
                    Read_Save_File.saveListIntoFile(st);
                    break;
                case 4:
                    System.err.println("Exitt....");
                    System.exit(0);
            }
        }
    }
}
