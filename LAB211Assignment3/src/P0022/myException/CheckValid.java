/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0022.myException;

import java.util.regex.Pattern;
import P0022.model.*;
import java.util.ArrayList;
public class CheckValid {//+^[0-9]{6}$
    static Pattern patternID= Pattern.compile("^([A-Za-z]{2})([0-9]{6})?$");      
    static Pattern patternPhone= Pattern.compile("^([0]{1})([1-9]{1})([0-9]{8})?$");
    static Pattern patternMail= Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    public static boolean checkUniqueID(ArrayList<Candidates> canList, String ID){
        //for(int i=0; i< control.canList.size(); i++)
        for(int i=0; i< canList.size(); i++){
            if(ID.equalsIgnoreCase(canList.get(i).getID()))
                return false;
        }
        return true;
    }
    public static boolean checkID(String str){
        if(patternID.matcher(str).find())
            return true;
        return false;
    }
    public static boolean checkMail(String str){
        if(patternMail.matcher(str).find())
            return true;
        return false;
    }
    public static boolean checkPhone(String str){
        if(patternPhone.matcher(str).find())
            return true;
        return false;
    }
        public static boolean checkBirthDate(int date, int month, int year){
        if(year<=1900)
            return false;
        if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
            if((date<=31)&&(date>=1))
                return true;
        if((month==4)||(month==6)||(month==9)||(month==11))
            if((date<=30)&&(date>=1))
                return true;
        if(year%4==0){
            if((date<=29)&&(date>=1))
                return true;
        }
        else if((date<=28)&&(date>=1))
                return true;
        return false;
    }
    public static boolean checkYearOfExperience(int YearOfExperience ){
        if((YearOfExperience>=0)&&(YearOfExperience<=100))
            return true;
        return false;
    }
    public static boolean checkRankOfGraduation(String rank){
        if(rank.equalsIgnoreCase("Excellence")||rank.equalsIgnoreCase("Good")||rank.equalsIgnoreCase("Fair")||rank.equalsIgnoreCase("Poor"))
            return true;
        return false;
    }
}
