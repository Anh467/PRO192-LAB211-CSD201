package method;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84384
 */
public class Control {
    // chuan hoa so du dau
    public static String standardNum(String num){
        int i=-1;
        int count= 0;
        while(num.charAt(i+1)=='-'||num.charAt(i+1)=='+'){
            if(num.charAt(i+1)=='-') ++count;
            ++i;
        }
        if(count%2==0) return num.substring(i+1);
        return "-"+num.substring(i+1);
    }
// chuan hoa so du so
    public static String standardZero(String num){
        if(num.length()==1) return num;
        int i= 0;
        while(num.charAt(i)=='0')
            ++i;
        if(i==0) return num;
        return num.substring(i);
    }
    public static String getString(){
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }
    public static boolean checkIsNum(String strNum){
        int i= 0;
        if(strNum.charAt(0)=='-'||strNum.charAt(0)=='+') ++i;
        for(; i< strNum.length(); i++)
            if(strNum.charAt(i)<48||strNum.charAt(i)>71)
                return false;
        return true;
    }
    public static boolean getFile(String path) {
        try {
            int i;
            FileInputStream fos = new FileInputStream(path);
            InputStreamReader osw = new InputStreamReader(fos);
            BufferedReader bw = new BufferedReader(osw);
            String line= bw.readLine();
            while(line!=null){
                System.out.println(line);
                line= bw.readLine();
            }
        fos.close();
        osw.close();
        bw.close();                 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void menu(String[]option){
        System.out.println(option[0]);
        for(int i= 0; i< option.length-1; i++)
            System.out.println(i+". "+option[i]);
        System.out.println(option[option.length-1]);
    }
    public static int getChoice(int i){
        int choice= 0;
        while (true) {            
            try {
                System.out.print("Enter choice: ");
                Scanner sc= new Scanner(System.in);
                choice= sc.nextInt();
                if(choice<0 && choice> i) throw new MyException("!!!WE DONT HAVE THAT OPTION!!!");
                return choice;
            } catch (MyException e) {
                System.err.println(e);
            }catch (Exception e) {
                System.err.println("!!!WRONG FORMAT!!!");
            }
        }
        
    }
}
