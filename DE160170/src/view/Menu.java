package view;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class Menu <T>{
    private String text;
    private ArrayList<T> option;
//construct
    public Menu(String text, String[] mOption) {
        this.text = text;
        option= new ArrayList<>();
        for(String s: mOption){
            option.add((T)s);
        }
    }
    public Menu() {
    }
//get set
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<T> getOption() {
        return option;
    }

    public void setOption(ArrayList<T> option) {
        this.option = option;
    }
//display
    public void display(){
        for(int i=0; i< option.size(); i++)
            System.out.println((i+1)+". "+option.get(i));
    }
//excute
    public abstract void excute();
//getselect
    public int getSelect(){
        Scanner sc= new Scanner(System.in);
        System.out.println(text);
        System.out.println("-------------------------");
        display();
        System.out.println("-------------------------");
        System.out.print("Enter Selection..");
        return sc.nextInt();
    }
}
