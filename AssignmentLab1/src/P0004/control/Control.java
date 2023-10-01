/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0004.control;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author 84384
 */
public class Control<E> {
    public static void view(){ 
    }
    public void swap(ArrayList<E> arr, int i, int j){
        E temp;
        temp= arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
//        model.getNum()[i]-= model.getNum()[j];
//        model.getNum()[j]+= model.getNum()[i];
//        model.getNum()[i]= model.getNum()[j]- model.getNum()[i];
    }
    public void QuickSort(ArrayList<E> arr, int i, int j) 
    {  
        
        int p=(int) arr.get((i+j)/2);
        int l= i, r= j;
        do {            
            while (((int)arr.get(i))<p)
                i++;
            
            while ((int)arr.get(j)>p)
                j--;
            
            if(i<=j){
                swap(arr, i,j);
                i++; j--;
            }
            if (i>j) break;
        } while (true);
        if(l<j) QuickSort(arr, l, j);
        if(i<r) QuickSort(arr, i, r);
    }  
    public ArrayList<E>  ActionQuickSort(ArrayList<E> arr){
        QuickSort(arr,0 , arr.size()-1);
        return arr;
    } 
    public String view(ArrayList <E> arr){
        String str="";
        for(int i=0; i< arr.size(); i++)
            str= str+ arr.get(i).toString()+", ";
        return str.substring(0, str.length()-2);
    }
    public static void main(String[] args) {
        Control con= new Control();
        ArrayList arr= new ArrayList();
        //4,7,8,9,10
        arr.add(4);
        arr.add(7);
        arr.add(1);
        arr.add(9);
        arr.add(10);
        System.out.println(con.view(arr));;
        con.ActionQuickSort(arr);
        System.out.println(con.view(arr));;
    }
}
