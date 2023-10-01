/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p0065;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Control {
    public static ArrayList<Student> readFile(String path) {
        ArrayList<Student> studentList= new ArrayList<>();
        try {
            Path filePath= Paths.get(path);
            List<String> studentString= Files.readAllLines(filePath);
            for(int i=0; i< studentString.size(); i++){
                String[] student= studentString.get(i).split("/");
                studentList.add(new Student(student[0], student[1], Double.parseDouble(student[2].trim()), Double.parseDouble(student[3].trim()), Double.parseDouble(student[4].trim())));
            }
            
        } catch (Exception e) {
            System.err.println("!!!READ FAIL!!!");
        }
        System.out.println("!!!READ SUCCESSFULL!!!");
        return studentList;
    }
    public static boolean saveFile(ArrayList<Student> studentList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for(int i= 0; i< studentList.size(); i++){
                bw.write(studentList.get(i).toString());
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
