/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0010.control;

import java.util.ArrayList;

/**
 *
 * @author 84384
 */
public class Control<E> {
    public int linearSearch(ArrayList <E> arr, int finNum){
        for(int i=0; i< arr.size(); i++)
            if(finNum==(int) arr.get(i))
                return i;
        return -1;
    }
    public String view(ArrayList <E> arr){
        String str="";
        for(int i=0; i< arr.size(); i++)
            str= str+ arr.get(i).toString()+", ";
        return str.substring(0, str.length()-2);
    }
}
