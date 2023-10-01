/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author 84384
 */
public class Validate {
    static Pattern patternUserName= Pattern.compile("^((\\w){5,})$");
    static Pattern patternPassWord= Pattern.compile("^((\\w){6,})$");
    public static boolean userNameCheck(String Code){
        if((Code.contains(" "))||(!patternUserName.matcher(Code).find()))
            return false;
        return true;
    }
    public static boolean passWordCheck(String Code){
        if((Code.contains(" "))||(!patternPassWord.matcher(Code).find()))
            return false;
        return true;
    }
    
}
