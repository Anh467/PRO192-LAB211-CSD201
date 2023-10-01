package j1_s_p0056;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Manager {

    public static int menu() {
        System.out.println("                               MENU\n"
                + "==========================================================================");
        System.out.println("1. Add Worker.");
        System.out.println("2. Read file and print worker list.");
        System.out.println("3. Up salary.");
        System.out.println("4. Down salary.");
        System.out.println("5. Display Information salary.");
        System.out.println("6. Exit.");

        int choice = Validate.inputInt("Please enter your choice: ", 1, 6);

        return choice;
    }

    public static void addWorker(ArrayList<Worker> wk) {
        boolean checkYN;
        do {
            String nID;
            do {
                nID = Validate.inputStr("Enter worker code: ").toUpperCase();
                if (Validate.CheckIdExist(wk, nID)) {
                    System.out.println("ID exist. Enter again.");
                }
            } while (Validate.CheckIdExist(wk, nID));
            String nName = Validate.makeNameRight(Validate.inputStr("Enter worker name: "));
            int nAge = Validate.inputInt("Enter worker age: ", 18, 50);
            int nsalary = Validate.inputInt("Enter worker salary: ", 0, 1000000000);
            String nWorkLocation = Validate.makeNameRight(Validate.inputStr("Enter work location: "));
            wk.add(new Worker(nID, nName, nAge, nsalary, nWorkLocation));
            System.err.println("Add " + nName + " successful.");
            System.out.print("Do you want countinue input country(Y/N): ");
            checkYN = Validate.checkInputYN();
        } while (checkYN == true);
    }

    public static void UpSalary(ArrayList<Worker> wk, ArrayList<History> hs) {
        if (wk.isEmpty()) {
            System.err.println("Empty list!!!");
            return;
        }
        String ID = Validate.inputStr("Enter worker code: ").toUpperCase();
        if (Validate.CheckIdExist(wk, ID) == false) {
            System.err.println("Worker " + ID + " not exsit in data base.");
        } else {
            Worker worker = Validate.getWorker(wk, ID);
            int salaryOld = worker.getSalary();
            int salaryNew;
            do {
                System.out.println("Current salary: " + salaryOld);
                salaryNew = Validate.inputInt("Enter new salary: ", 0, 1000000000);
                if (salaryNew <= salaryOld) {
                    System.out.println("New Salary must bigger than old Salary. Enter again.");
                }
            } while (salaryNew <= salaryOld);
            String nDate = Manager.getCurrentDate();
            hs.add(new History(ID, worker.getName(), worker.getAge(), salaryNew, worker.getWorkLocation(), "UP", nDate));
            worker.setSalary(salaryNew);
            System.err.println("Update success!!");
        }
    }

    public static void DownSalary(ArrayList<Worker> wk, ArrayList<History> hs) {
        if (wk.isEmpty()) {
            System.err.println("Empty list!!!");
            return;
        }
        String ID = Validate.inputStr("Enter worker code: ").toUpperCase();
        if (Validate.CheckIdExist(wk, ID) == false) {
            System.err.println("Worker " + ID + " not exsit in data base.");
        } else {
            Worker worker = Validate.getWorker(wk, ID);
            int salaryOld = worker.getSalary();
            int salaryNew;
            do {
                System.out.println("Current salary: " + salaryOld);
                salaryNew = Validate.inputInt("Enter new salary: ", 0, 1000000000);
                if (salaryNew >= salaryOld) {
                    System.out.println("New Salary must smaller than old Salary. Enter again.");
                }
            } while (salaryNew >= salaryOld);
            String nDate = Manager.getCurrentDate();
            hs.add(new History(ID, worker.getName(), worker.getAge(), salaryNew, worker.getWorkLocation(), "DOWN", nDate));
            worker.setSalary(salaryNew);
            System.err.println("Update success!!");
        }
    }

    public static void printHistory(History history) {
        System.out.printf("%-10s%-30s%-10d%-15d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }

    public static void printListHistory(ArrayList<History> lh) {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-10s%-30s%-10s%-15s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        //print history from first to last list
        for (History history : lh) {
            printHistory(history);
        }
    }

    public static void printWorker(Worker worker) {
        System.out.printf("%-10s%-30s%-10d%-15d%-20s\n", worker.getId(),
                worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
    }

    public static void printListWorker(ArrayList<Worker> wk) {
        if (wk.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-10s%-30s%-10s%-15s%-20s\n", "Code", "Name", "Age",
                "Salary", "Work Location");
        //print history from first to last list
        for (Worker worker : wk) {
            printWorker(worker);
        }
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

}
