
import java.util.ArrayList;

public class Manage {
    static ArrayList<Expense> expenseArrayList = new ArrayList<>();

    public Manage() {
    }

    public Manage (ArrayList<Expense> expenseArrayList) {
        this.expenseArrayList = expenseArrayList;
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }

    public void setExpenseArrayList(ArrayList<Expense> expenseArrayList) {
        this.expenseArrayList = expenseArrayList;
    }

    public void add(Expense expense) {
        expenseArrayList.add(expense);
    }

    public static Expense getExpenseByID(int idDelete) {
        ArrayList<Expense> list = Manage.expenseArrayList;
        for (Expense expense : list) {
            if (expense.getID() == idDelete) {
                return expense;
            }
        }
        return null;
    }

}
