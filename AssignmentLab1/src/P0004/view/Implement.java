/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0004.view;
import java.util.ArrayList;
import java.util.Scanner;
import P0004.control.Control;
import java.util.Collections;
import java.util.Random;
public class Implement {
        public static ArrayList<Integer> randNum(int i){
        ArrayList<Integer> numList=new ArrayList<>();
        while(i!=0){
            Random generator = new Random();
            numList.add(generator.nextInt(100+1)); 
            i--;
        }
        return numList;
    }
    public static int getInput(){
        int num;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of array:");
        while(true){
            try {
                int n= sc.nextInt();
                if(n<=0) throw new Exception();
                else
                    num= n;
                break;
            } catch (Exception e) {
                System.out.println("Inappropriate input, try again:");
                System.out.println("Enter number of array:");
                sc.nextLine();
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
        Control control= new Control();
        ArrayList<Integer> numList= randNum(getInput());
        //System.out.println(numList.size());
        System.out.println(control.view(numList));
        numList= control.ActionQuickSort(numList);
        System.out.println(control.view(numList));
    }

}
