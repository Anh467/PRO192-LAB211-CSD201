/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059.validate;

import java.io.File;

/**
 *
 * @author 84384
 */
public class Validate {
    public static boolean checkPath(String path){
        if(new File(path).exists())
            return true;
        return false;
    }
    public static String standard(String str){
        str= str.trim().toLowerCase();
        while(str.contains("  "))
            str= str.replaceAll("  ", " ");
        char[] strArr= str.toCharArray();
        strArr[0]= Character.toUpperCase(strArr[0]);
        for(int i=0; i< strArr.length; i++)
            if(strArr[i]==' ')
                strArr[i+1]= Character.toUpperCase(strArr[i+1]);
        return String.valueOf(strArr);
    }
    public static boolean checkNewFile(String path, String nameNewFile){      
        try {
            File fileNew= new File(path.substring(0, path.lastIndexOf("\\"))+nameNewFile);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
