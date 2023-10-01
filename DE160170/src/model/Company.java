package model;
import java.util.ArrayList;
import fileIO.FileIO;
import java.nio.file.Paths;
import java.util.Scanner;
import model.Customer;
import Control.Method;
import myException.MyException;
public class Company {
    public static String str= Paths.get("").toAbsolutePath().toString();
    public static String path=str+"/src/model/company.txt"; 
    public static ArrayList<Customer> cusList= new ArrayList<>();
    public static void readFile(){
        FileIO IO= new FileIO();
        cusList.addAll(IO.readFile(path));
    }
    public static void printAll(){
        System.out.println("List of Customer");
        System.out.println("--------------------------");
        for(int i=0; i<cusList.size(); i++)
            System.out.println(cusList.get(i).toString());
        System.out.println("--------------------------");
        System.out.println("Total : "+cusList.size()+" customers");
    }
    public static int findID(String str){
        for(int i=0; i< cusList.size(); i++)
            if(str.equalsIgnoreCase(cusList.get(i).getCustomerID()))
                return i;
        return -1;
    }
    public static void insertCus(){
        String ID="", name="", phone="";
        Method method= new Method();
        try {
            Scanner sc= new Scanner(System.in);
            while(true){
                try {
                    System.out.print("Enter CustomerID: ");
                        ID= sc.nextLine();
                    if(findID(ID)!=-1) throw new MyException("!!!ID MUST BE UNIQUE!!!");
                    break;
                } catch(MyException e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                    System.out.println("!!!ID wrong format!!!");
                }
            }
                System.out.print("Enter Name: ");
                name= sc.nextLine();
            while(true){
                try {
                    System.out.print("Enter Phone: ");
                        phone= sc.nextLine();
                    if(method.checkPhone(phone)==false) throw new MyException("!!!PHONE WRONG FORMAT EX:/0xxxxxxxxx/with x is number!!!");
                    break;
                } catch(MyException e){
                    System.out.println(e.getMessage());
                }catch (Exception e) {
                    System.out.println("!!!ID wrong format!!!");
                }
            }
        } catch (Exception e) {
        }
        cusList.add(new Customer(ID, method.standard(name), phone));
        System.out.println("!!!ADD SUCCESSFULL!!!");
    }
    public static void cusSearch(int k){
        String str;
        int j=0;
        Scanner sc= new Scanner(System.in);
        if(k==1){   
            System.out.print("Enter ID of Customer: ");
                str= sc.nextLine();
            System.out.println("----------------------------");
            for(int i=0; i< cusList.size(); i++){
                
                if(str.equalsIgnoreCase(cusList.get(i).getCustomerID())){
                    System.out.println(cusList.get(i).toString());
                j++;
                }
            }
            System.out.println("----------------------------");
        }else{
            System.out.print("Enter Name of Customer: ");
                str= sc.nextLine();
            System.out.println("----------------------------");
            for(int i=0; i< cusList.size(); i++){
               
                if(cusList.get(i).getName().toLowerCase().contains(str.toLowerCase())){
                    System.out.println(cusList.get(i).toString());
                 j++;
                }
            }
            System.out.println("----------------------------");
        }
        System.out.println("Total : "+j+" customers");
    }
    public static void satic(int k){
        System.out.println("List of Customer");
        int j=0;
        System.out.println("--------------------------");
        if(k==1)
            for(int i=0; i<cusList.size(); i++){
                if(cusList.get(i).getPhone().contains("098")){
                    System.out.println(cusList.get(i).toString());
                j++;
                }
            }
        else if(k==2)
            for(int i=0; i<cusList.size(); i++){
                if(cusList.get(i).getPhone().contains("091")){
                    System.out.println(cusList.get(i).toString());
                j++;
                }
            }
        else 
            for(int i=0; i<cusList.size(); i++){
                if(cusList.get(i).getPhone().contains("090")){
                    System.out.println(cusList.get(i).toString());
                j++;
                }
            }
        System.out.println("--------------------------");
        System.out.println("Total : "+j+" Customer");
    }
}
