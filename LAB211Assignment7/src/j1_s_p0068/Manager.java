package j1_s_p0068;

import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    public static int menu() {
        System.out.println("====== Collection Sort Program ======");
        System.out.println("1. Add Student.");
        System.out.println("2. Print List.");
        System.out.println("3. Save list to file.");
        System.out.println("4. Exit.");

        int choice = Validate.inputInt("Please enter your choice: ", 1, 4);

        return choice;
    }

    public static void addStudent(ArrayList<Student> st) {
        String nName, nClass;
        double nMark;
        boolean checkY_N = false;
        do {
            System.out.println("Please input student information ");
            nName = Validate.makeNameRight(Validate.inputStr("Name: "));
            nClass = Validate.inputStr("Classes: ").toUpperCase();
            nMark = Validate.inputDouble("Mark: ", 0, 100);
            st.add(new Student(nName, nClass, nMark));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            checkY_N = Validate.checkInputYN();
        } while (checkY_N == true);
    }

    public static void printStudent(ArrayList<Student> st) {
        int count = 1;
        if (st.isEmpty()) {
            System.err.println("Empty List!!!");
            return;
        } else {
            Collections.sort(st);
            for (int i = 0; i < st.size(); i++) {
                System.out.println("-------------Student " + (count++) + "-------------");
                System.out.format("Name: %s\nClasses: %s\nMark: %f\n", st.get(i).getName(), st.get(i).getClasses(), st.get(i).getMark());
            }
        }
    }
}
