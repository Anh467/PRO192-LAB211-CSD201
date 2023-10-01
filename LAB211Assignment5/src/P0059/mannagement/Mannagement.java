/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059.mannagement;
import P0059.control.Control;
import P0059.model.Person;
import P0059.validate.Validate;
import java.util.ArrayList;
import java.util.Scanner;
public class Mannagement {
    ArrayList<Person> personList= new ArrayList<>();
    public void readFile() {
        System.out.println("--------- Person info ---------");
        personList.addAll(Control.readFile(getInputPath("Enter Path: ")));
    }
    public String getInputPath(String Str){
        String path;
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                System.out.print(Str);
                path= sc.nextLine();
                if(!P0059.validate.Validate.checkPath(path)) throw new P0059.validate.MyException("!!!Path doesn't exist!!!");
                return path;
            } catch (P0059.validate.MyException e) {
                System.err.println(e.getMessage());
            }catch (Exception e) {
            }
        }
    }
    public void copyText(){
        String path= getInputPath("Enter Source: ");
        Scanner sc= new Scanner(System.in);
        String name;
        while (true) {            
            try {
                System.out.print("Enter Name: ");
                name= sc.nextLine();
                if(!Validate.checkNewFile(path, name)) throw new P0059.validate.MyException("!!!WRONG NAME!!!");
                break;
            } catch (P0059.validate.MyException e) {
            }catch (Exception e) {
            }
        }
        Control.saveFile(path, name);
        System.out.println("Copy done...");
    }
    public String finMinMax(ArrayList<Person> personDraft){
        if(personDraft.isEmpty()) return "";
        personDraft.sort((o1, o2) -> {
            return o1.getMoney().compareTo(o2.getMoney()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/LambdaBody
        });
        return "Max: "+ personDraft.get(personDraft.size()-1).getName()+"\n"+"Min: "+personDraft.get(0).getName();
    }
    public void disPlay(){
        double num;
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                System.out.print("Enter Money: ");
                num= Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("!!!WRONG FORMAT!!!");
            }
        }
        System.out.println("------------- Result ----------");
        System.out.format("%-15s%-20s%-10s\n", "Name", "Address", "Money");
        ArrayList<Person> personDraft= new ArrayList<>();
        for(int i= 0; i< personList.size(); i++)
            if(personList.get(i).getMoney()>num){
                personList.get(i).view();
                personDraft.add(personList.get(i));
            }
        System.out.println(finMinMax(personDraft));
    }
}
