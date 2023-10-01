/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0062;
    
import java.io.File;
import java.util.Scanner;
public class Control {

    public static void checkInputPath(String path) {
        File file = new File(path);
        try {
             if (file.exists() && file.isFile()) {
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));
            System.out.println("Folders: " + getForder(path));
            } else throw new MyException("!!!INAPPROPRIATE PATH!!!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
        }
       
    }

    public static String getPath(String path) {
        return path.substring(path.indexOf("\\")+ 1,  path.lastIndexOf("\\"));
    }

    public static String getFileName(String path) {
        return path.substring(path.lastIndexOf("\\") + 1, path.lastIndexOf("."));
    }

    public static String getExtension(String path) {
        return path.substring(path.lastIndexOf(".")+1, path.length());
    }

    public static String getDisk(String path) {
        return path.substring(0, path.indexOf("\\") + 1);
    }

    public static String getForder(String path) {
        return path.substring( path.indexOf("\\")+1, path.substring(0,path.indexOf("\\")).length()+(path.substring(path.indexOf("\\")+1)).indexOf("\\")+1);
    }

}

