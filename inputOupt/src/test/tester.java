/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import java.util.ArrayList;
import io.FileIO;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import model.*;

/**
 *
 * @author 84384
 */
public class tester {
    public static void main(String[] args) {    
        ArrayList<Student> stuList= new ArrayList<>();
        String path="C:\\Users\\84384\\Documents\\NetBeansProjects\\inputOupt\\src\\file\\Student.txt";
        //System.out.println(stuList.get(0).toString());
        stuList.add(new Student("DE160170", "vietnade160170@gmail.com", 7.6, "Nguyen Anh Viet", "Quang Ngai", "08-07-2002", true));
        stuList.add(new Student("DE160121", "khanhnade160170@gmail.com", 9.6, "Nguyen Anh Khanh", "Quang Nam", "01-02-2002", true));
        stuList.add(new Student("De170140", "duyennade160170@gmail.com", 5.6, "Nguyen Ky Duyen", "Quang Hue", "11-05-2001", false));
        stuList.add(new Student("DE160192", "hungnade160170@gmail.com", 4.6, "Nguyen Anh Hung", "Quang Nam", "05-01-2002", true));
        stuList.add(new Student("DE120170", "ngocnade160170@gmail.com", 5.7, "Nguyen Hoang Ngoc", "Ha noi", "05-11-2002", false));
        if(FileIO.SaveFile(stuList,path))
            System.out.println("save successfull");
        else System.out.println("save fail");
        ArrayList<Student> stuNew= new ArrayList<>();
        stuNew.addAll(FileIO.readObjectFile(path));
        stuNew.forEach((t) -> {
            System.out.println(t.toString());
        });
    }
    
}
