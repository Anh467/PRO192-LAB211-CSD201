/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0006.control;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author 84384
 */
public class Control<E> {
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
    public int binary(ArrayList<E> arr, int i, int j, int numFind){
        if(numFind==(int) arr.get((i+j)/2))
            return ((i+j)/2);
        else if(i<j){
            if(numFind> (int) arr.get((i+j)/2)) return binary(arr, ((i+j)/2) +1, j, numFind);
            else if(numFind< (int) arr.get((i+j)/2)) return binary(arr, i, ((i+j)/2) -1, numFind);
        } 
        return -1;
    }
    public void binarySearch(ArrayList<E> arr, int numFind){
        output(arr, binary(arr, 0, arr.size()-1, numFind), numFind);
    }
    public String view(ArrayList <E> arr){
        String str="";
        for(int i=0; i< arr.size(); i++)
            str= str+ arr.get(i).toString()+", ";
        return str.substring(0, str.length()-2);
    }
    public void output(ArrayList<E> arr, int index, int numFind){
        System.out.println("Sorted array: ["+view(arr)+"]");
        if(index!=-1)
            System.out.println("Found "+numFind+" at index: "+index);
        else System.out.println("Cant find "+numFind+" in array");
    }
}
