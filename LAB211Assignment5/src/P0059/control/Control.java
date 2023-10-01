/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059.control;
import P0055.validate.MyException;
import P0059.model.Person;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Control {
    public static ArrayList<Person> readFile(String path){
        Scanner sc= new Scanner(System.in);
        ArrayList<Person> personList= new ArrayList<>();
        try {
            Path filePath= Paths.get(path);
            List<String> personString= Files.readAllLines(filePath);
            for(int i=0; i< personString.size(); i++){
                String[] person= personString.get(i).split(";");
                String name= P0059.validate.Validate.standard(person[0]);
                String address= P0059.validate.Validate.standard(person[1]);
                double money;
                try {
                    money= Double.parseDouble(person[2].trim());
                    if(money<=0) continue;
                } catch (Exception e) {
                    continue;
                }
                personList.add(new Person(name, address, money));
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        return personList;
    }
    public static void saveFile(String path, String nameNewFile){
        try {

            File fileCopy= new File(path);  
            Path pathFileCopy= Paths.get(path);
            File fileNew= new File(path.substring(0, path.lastIndexOf("\\"))+"\\"+nameNewFile);
//            if(!fileNew.isFile())
//                fileNew.createNewFile();
            FileWriter fw= new FileWriter(fileNew, true);
            List<String> str= Files.readAllLines(pathFileCopy);
            for(int i=0; i< str.size(); i++)
                fw.write("\n"+str.get(i));
            fw.close();
        } catch (Exception e) {
            System.err.println("!!Can’t write file!!!");
        }
    }
        public static void menu(String[] option){
        System.out.println("========= "+ option[0]+" =========");
        for(int i= 1; i< option.length; i++)
            System.out.println("     "+i+". "+option[i]);
        System.out.print("Choose: ");
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
