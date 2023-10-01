/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0004.control;
import java.util.Random;
import java.util.ArrayList;
import P0001.model.Model;
/**
 *
 * @author 84384
 */
public class Control {
    public static Model model= new Model();
 //   public static int[] num= model.getNum();
    public static void randNum(int i){
        int[] num= new int[i];
        for(int j=0; j<i; j++){
            Random generator = new Random();
            num[j]=generator.nextInt(i+1); 
        }
        model.setNum(num);
    }
    public static void view(){ 
        for(int i=0;i<model.getNum().length-1; i++)
            System.out.print(model.getNum()[i]+", ");
        System.out.println(model.getNum()[model.getNum().length-1]+"]");
    }
    public static void sortBuble(){
        for(int i=0; i< model.getNum().length; i++)
            for(int j=0; j<model.getNum().length-1; j++)
                if(model.getNum()[i]<model.getNum()[j]){
                    model.getNum()[i]-=model.getNum()[j];
                    model.getNum()[j]+=model.getNum()[i];
                    model.getNum()[i]=model.getNum()[j]-model.getNum()[i];
                }
    }
    public static void sortSelect(int[] num){
        for(int i=0; i< model.getNum().length; i++)
            for(int j=i; j<model.getNum().length; j++)
                if(model.getNum()[i]>model.getNum()[j]){
                    model.getNum()[i]-=model.getNum()[j];
                    model.getNum()[j]+=model.getNum()[i];
                    model.getNum()[i]=model.getNum()[j]-model.getNum()[i];
                }
    }
    public static void sortInsetion(){
        int n = model.getNum().length;
        for (int i = 1; i < n; ++i) {
            int key = model.getNum()[i];
            int j = i - 1;
            while (j >= 0 && model.getNum()[j] > key) {
                model.getNum()[j + 1] = model.getNum()[j];
                j = j - 1;
            }
            model.getNum()[j + 1] = key;
        }
    }
    public static void swap(int i, int j){
        int temp;
        temp= model.getNum()[i];
        model.getNum()[i]= model.getNum()[j];
        model.getNum()[j]= temp;
//        model.getNum()[i]-= model.getNum()[j];
//        model.getNum()[j]+= model.getNum()[i];
//        model.getNum()[i]= model.getNum()[j]- model.getNum()[i];
    }
    public static void QuickSort(int i, int j) 
    {  
        
        int p=model.getNum()[(i+j)/2];
        int l= i, r= j;
        do {            
            while (model.getNum()[i]<p){
                i++;
            }
            while (model.getNum()[j]>p){
                j--;
            }
            if(i<=j){
                swap(i,j);
                i++; j--;
            }
            if (i>j) break;
        } while (true);
        if(l<j) QuickSort(l, j);
        if(i<r) QuickSort(i, r);
    }  
    public static void ActionQuickSort(){
        QuickSort(0 , model.getNum().length-1);
    } 
}
