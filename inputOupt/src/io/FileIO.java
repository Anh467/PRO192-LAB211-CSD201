
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

public class FileIO {
    
    public static boolean saveFile(ArrayList<Student> stuList, String path) {
        
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Student st : stuList) {
                //st.toString();
                bw.newLine();
                bw.write(st.toString());
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
    public static boolean saveString(String str, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.newLine();
            bw.write(str);
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
    public static boolean SaveFile(ArrayList<Student> stdList, String path){
        System.out.println(stdList.get(0).toString());
        try {
            FileOutputStream fos= new FileOutputStream(path);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(stdList);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Student> readObjectFile(String path){
        ArrayList<Student> stu= new ArrayList<>();
        try {
            FileInputStream fis= new FileInputStream(path);
            ObjectInputStream ois= new ObjectInputStream(fis);
            stu.addAll((ArrayList<Student> ) ois.readObject());
            fis.close();
            ois.close();
            return stu;
        } catch (Exception e) {
        }
        return stu;
    }

}

