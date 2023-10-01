/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021.main;
import P0021.mannagement.Mannagement;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Mannagement view= new Mannagement();
        String path= Paths.get("").toAbsolutePath().toString();
        view.readFile(path+"/src/P0021/model/student.txt");
        String[] option= {"Create", "Find and Sort","Update/Delete","Report","Exit"};
        int choose;
        do{
            view.mainScreen(option);
            choose= view.getInput();
            switch (choose) {
                case 1: view.create();
                    break;
                case 2: view.findAndSort();
                    break;
                case 3: view.modifyStudent();
                    break;
                case 4: view.report();
                    break;
                case 5: break;
            }
        }while(choose!=5);
        view.saveString(path+"/src/P0021/model/student.txt");
    }
}
