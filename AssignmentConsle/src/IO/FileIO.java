
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;
import DTO.Student;
import DTO.BIZ;
import DTO.IT;
public class FileIO {
    
    public static boolean saveFile(ArrayList<Student> stuList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Student st : stuList) {
                if(st instanceof IT)
                bw.write(((IT)st).toString());
                else bw.write(((BIZ)st).toString());
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
}

