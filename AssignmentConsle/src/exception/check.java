/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import java.util.regex.Pattern;

/**
 *
 * @author 84384
 */
public class check {//+^[0-9]{6}$
    Pattern patternID= Pattern.compile("^([A-Za-z]{2})([0-9]{6})?$");
    Pattern patternMail= Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
            
    public boolean checkID(String str){
        if(patternID.matcher(str).find())
            return true;
        return false;
    }
    
    public boolean checkMail(String str){
        if(patternMail.matcher(str).find())
            return true;
        return false;
    }

}
