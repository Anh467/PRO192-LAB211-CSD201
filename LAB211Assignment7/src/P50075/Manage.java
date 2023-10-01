
import java.util.ArrayList;

public class Manage {
    static ArrayList<Expense> expenseArrayList = new ArrayList<>();
    public void add(){
        expenseArrayList.add(new Expense(1, "13/11/2005", 3422, "content"));
        expenseArrayList.add(new Expense(2, "17/10/2000", 3422, "content"));
         expenseArrayList.add(new Expense(3, "09/5/2007", 3422, "content"));
          expenseArrayList.add(new Expense(4, "15/01/2001", 3422, "content"));
           expenseArrayList.add(new Expense(5, "14/12/2002", 3422, "content"));
            expenseArrayList.add(new Expense(6, "24/10/2004", 3422, "content"));
    }
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
