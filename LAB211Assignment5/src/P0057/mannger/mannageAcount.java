package P0057.mannger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.nio.file.Paths;
import P0057.Control.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import P0057.resource.Account;
import P0057.validation.*;
public class mannageAcount {
    Map<String,Account> accountList= new LinkedHashMap<>();
    public void getData(){
        String path= Paths.get("").toAbsolutePath().toString();
        accountList.putAll(Control.readFile(path+"/src/P0057/resource/superSecretInformation.txt"));
    }
    public void saveData(){
        String path= Paths.get("").toAbsolutePath().toString();
        Control.saveFile(path+"/src/resource/superSecretInformation.txt", accountList);
    }
    public String getUserName(){
        Scanner sc= new Scanner(System.in);
        String code;
        while (true) {
            try {
                System.out.print("Enter Username: ");
                code= sc.nextLine();
                if(!Validate.userNameCheck(code)) throw new MyException("You must enter least at 5 character, and no space!");
                if(accountList.containsKey(code)) throw new MyException("This user name was taken");
                return code;
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }catch (Exception e) {
            }  
        }
    }
    public String getPassWord(){
        Scanner sc= new Scanner(System.in);
        String code;
        while (true) {
            try {
                System.out.print("Enter Password: ");
                code= sc.nextLine();
                if(!Validate.userNameCheck(code)) throw new MyException("You must enter least at 6 character, and no space!");
                return code;
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }catch (Exception e) {
            }  
        }
    }
    public void createNewAcount(){
        String userName= getUserName();
        String passWord= getPassWord();
        accountList.put(userName, new Account(userName, passWord));
        System.out.println("!!!Create Account successfull!!!");
    }
    public boolean login(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Username: ");
            String Username= sc.nextLine();
        System.out.print("Enter Password: ");
            String Password= sc.nextLine();
        if(!accountList.containsKey(Username)) return false;
        if(!accountList.get(Username).getPassWord().equals(Password)) return false;
        return true;
    }
}
