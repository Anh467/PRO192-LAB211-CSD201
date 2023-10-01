package p0065;
import p0065.Manager;
public class menu {
    public static void main(String[] args) {
        String[] option={"Management Student Program ","Create Student","Display"};
        Manager ma= new Manager();
        ma.getData();
        int choice=0;
        do {            
            Control.menu(option);
            choice= Control.getChoice();
            switch (choice) {
                case 1: ma.createStudent();
                        break;
                case 2: ma.display();
                        break;
                default:
                    break;
            }
        } while (choice!=3);
        ma.saveDate();
    }
    
   
}
