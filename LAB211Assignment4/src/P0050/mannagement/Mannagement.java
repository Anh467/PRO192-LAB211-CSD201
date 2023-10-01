/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0050.mannagement;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Mannagement {
    public void mainScreen(String[] option){
        System.out.println("=========Equation Program=========");
        for(int i=0; i< option.length; i++)
            System.out.format("%d. %s\n",i+1, option[i]);
        System.out.print("Please choice one option: ");
//        for(int i=0; i< option.length-1; i++)
//            System.out.format(" %d to %s,",i+1, option[i]);
//        System.out.format(" %d to %s). ",option.length, option[option.length-1]);
    }
    public int getInput(){
        int input;
        Scanner sc= new Scanner(System.in);
        try {
            input= sc.nextInt();
            if((input<1)||(input>3)) throw new MyException("!!!INAPPRIOPRIATE OPTION!!!");
            else return input;
        }catch(MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("!!!INPUT WRONG FORMAT!!!");
        }
        return -1;
    }
}
