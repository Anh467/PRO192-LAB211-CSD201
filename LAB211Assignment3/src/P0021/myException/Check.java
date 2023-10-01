/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021.myException;

import java.util.regex.Pattern;

/**
 *
 * @author 84384
 */
public class Check {//+^[0-9]{6}$
    Pattern patternID= Pattern.compile("^([A-Za-z]{2})([0-9]{6})?$");           
    public boolean checkID(String str){
        if(patternID.matcher(str).find())
            return true;
        return false;
    }
}
