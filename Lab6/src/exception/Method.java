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
public class Method {
    Pattern patternID= Pattern.compile("^([Bb]{1})([0-9]{4})?$");
    
    public boolean checkID(String str){
        if(patternID.matcher(str).find())
            return true;
        return false;
    }
    
    public String standardStatic(String str){
        char[] charArray= str.toCharArray();
        charArray[0]= Character.toUpperCase(str.charAt(0));
        int length= charArray.length;
        for(int i=1; i< length; i++)
                if(charArray[i]==' '){
                    while(charArray[i+1]==' '){
                        for(int j=i+1; j<length-1; j++)
                            charArray[j]=charArray[j+1];
                        length-=1;
                    }

                    charArray[i+1]= Character.toUpperCase(charArray[i+1]);
                }
        return String.valueOf(charArray).substring(0, length);
    }
}
