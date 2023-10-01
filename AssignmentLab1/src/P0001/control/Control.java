/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0001.control;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 84384
 */
public class Control<E> {
    
 //   public static int[] num= model.getNum();

    public  ArrayList<E> sortBuble(ArrayList<E> arr){
        for(int i=0; i< arr.size(); i++)
            for(int j=0; j<arr.size()-1; j++)
                if((int)arr.get(i)< (int)arr.get(j)){
                    E temp= arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
        return arr;
    }
    public String view(ArrayList <E> arr){
        String str="";
        for(int i=0; i< arr.size(); i++)
            str= str+ arr.get(i).toString()+", ";
        return str.substring(0, str.length()-2);
    }

}
