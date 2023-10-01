/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055.validate;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author 84384
 */
public class Validate {
    public static String checkCode(String Code){
        Pattern patternCode= Pattern.compile("^((DOC){1})((\s){1})([0-9]+)?$");
        if(patternCode.matcher(Code).find())
            return Code;
        return "";
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
    public static int number(String number){
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(checkCode("CODE 12"));
        System.out.println(standard("nguyEn    aNh VieT"));
        System.out.println(number("234.4"));
    }
    
}
