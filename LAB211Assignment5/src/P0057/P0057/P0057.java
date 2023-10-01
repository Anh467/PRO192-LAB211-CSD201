package P0057.P0057;


import P0057.resource.*;
import P0057.validation.*;
import P0057.Control.*;
import P0057.mannger.*;
public class P0057 {
    public static void main(String[] args) {
        int choice;
        String[] option= {"USER MANAGEMENT SYSTEM", "Create a new account", "Login system", "Exit"};
        mannageAcount mannage= new mannageAcount();
        mannage.getData();
        do {            
            Control.menu(option);
            choice= Control.getChoice();
            switch (choice) {
                case 1: mannage.createNewAcount();
                    break;
                case 2: if(mannage.login()){
                            System.out.println("!!!Login successfull!!!");
                        }else
                        System.err.println("MAYBE UR USERNAME OR PASSWORD WRONG");
                case 3:
                    break;
            }
        } while (choice!=3);
        mannage.saveData();
    }
}
