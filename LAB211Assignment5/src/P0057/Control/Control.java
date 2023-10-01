package P0057.Control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import P0057.resource.*;
import P0057.validation.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Control {
    public static Map<String,Account> readFile(String path){
        Map<String,Account> accountList= new LinkedHashMap<>();
        try {
            Path filePath= Paths.get(path);
            List<String> accountString= Files.readAllLines(filePath);
            for(int i=0; i< accountString.size(); i++){
                String[] acoount= accountString.get(i).split("/");
                accountList.put(acoount[0],new Account(acoount[0], acoount[1]));
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        System.out.println("!!!READ SUCCESSFULL!!!");
        return accountList;
    }
    public static boolean saveFile(String path, Map<String,Account> accountList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for(Account acountInfor: accountList.values()){
                bw.write(acountInfor.getUserName()+"/ "+acountInfor.getPassWord());
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void menu(String[] option){
        System.out.println("========= "+ option[0]+" =========");
        for(int i= 1; i< option.length; i++)
            System.out.println("     "+i+". "+option[i]);
        System.out.print("> Choose: ");
    }
    public static int getChoice(){
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                int num= Integer.parseInt(sc.nextLine());
                if((num<1)&&(num>3)) throw new MyException("!!!WE DONT HAVE THIS OPTION!!!");
                return num;
            }catch (MyException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("!!!WRONG FORMAT!!!");
            }
        }
    }
    
}
