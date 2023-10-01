/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0010.view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import P0010.control.Control;
/**
 *
 * @author 84384
 */
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
    
    public static int getInput(String str){
        int num;
        Scanner sc= new Scanner(System.in);
        
        while(true){
            try {
                System.out.println(str);
                int n= sc.nextInt();
                if(n<=0) throw new Exception();
                else{
                    num= n;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Inappropriate input, try again:");
                sc.nextLine();
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
        Control control= new Control();
        
        ArrayList<Integer> numList= randNum(getInput("Enter number of array:"));
        int findNum= getInput("Enter search value: ");
        System.out.println("The array: ["+control.view(numList)+"]");
        int index= control.linearSearch(numList, findNum);
        if(index!=-1)
            System.out.println("Found "+findNum+" at index:" +index);
        else System.out.println("Number "+findNum+ " doesnt exist in array");
    }
}
