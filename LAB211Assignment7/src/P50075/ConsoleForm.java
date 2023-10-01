import java.util.ArrayList;

public class ConsoleForm {
    Manage manage = new Manage();

    public int getChoice() {
        System.out.println("=======Handy Expense program======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expense");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputLimit(1, 4);
        return choice;
    }

    public void addExpense() {
        Expense expense = new Expense();
        while (true) {
            System.out.println("-------- Add an expense--------");
            int ID;
            if (manage.getExpenseArrayList().isEmpty()) {
                ID = 1;
            } else {
                ID = manage.getExpenseArrayList().get(manage.getExpenseArrayList().size() - 1).getID() + 1;
            }
            expense.setID(ID);
            
            System.out.println("Enter Date: ");
            expense.setDate(Validation.checkDate());
            System.out.println("Enter Amount: ");
            expense.setAmount(Validation.checkInputDouble());
            System.out.println("Enter Content: ");
            expense.setContent(Validation.checkInputString());
            manage.add(expense);
            System.out.println("Do you want continue? (Y/N)");
            if (Validation.checkYN() == false) break;
        }
    }

    public void displayAllExpense() {

        if (manage.expenseArrayList.isEmpty()) {
            System.err.println("List Expense empty");
            return;
        }
        double total = 0;
        System.out.println("---------Display all expenses------------");
        System.out.format("%-5s%-30s%-10s%-15s\n", "ID", "Date", "Amount of money", "Content");
        for (Expense e : manage.getExpenseArrayList()) {
            e.view();
            total += e.getAmount();
        }
        System.out.format("Total: %.0f\n", total);
    }

    public void deleteExpense() {
        while (true) {
            ArrayList<Expense> list = Manage.expenseArrayList;
            System.out.println("--------Delete an expense------");
            System.out.println("Enter ID: ");
            int idDelete = Validation.checkInputInteger();
            if (list.isEmpty()) {
                System.out.println("List empty");
                return;
            }
            Expense expenseDelete = Manage.getExpenseByID(idDelete);
            if (expenseDelete == null) {
                System.out.println("Delete an expense fail");
                return;
            } else {
                list.remove(expenseDelete);
                System.out.println("Delete an expense successful");
            }
        }
    }


    public void execute() {
        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAllExpense();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
