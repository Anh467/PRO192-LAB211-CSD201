/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051.control;

import P0051.myException.MyException;
import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Control {
    public void mainScreen(String[] option){
        System.out.println(option[0]);
        for(int i=1; i< option.length; i++)
            System.out.format("%d. %s\n",i, option[i]);
        System.out.print("Please choice one option: ");
//        for(int i=0; i< option.length-1; i++)
//            System.out.format(" %d to %s,",i+1, option[i]);
//        System.out.format(" %d to %s). ",option.length, option[option.length-1]);
    }
    public int getInput(){
        int input;
        
        while (true) {            
            try {
                Scanner sc= new Scanner(System.in);
                input= sc.nextInt();
                if((input<1)||(input>3)) throw new P0050.mannagement.MyException("!!!INAPPRIOPRIATE OPTION!!!");
                else return input;
            }catch(P0050.mannagement.MyException e){
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("!!!INPUT WRONG FORMAT, try again!!!");
            }
        }
    }
    public boolean CheckOperator(String operator){
        if((operator.equals("+"))||(operator.equals("-"))||(operator.equals("*"))||(operator.equals("/"))||(operator.equals("^"))||(operator.equals("=")))
            return true;
        return false;
    }
    public double getDouble(String text1, String text2){
        double number;
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                System.out.print(text1);
                number= Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.err.println(text2);
            }
        }
    }
    public String getOperator(){
        String operator;
        Scanner sc= new Scanner(System.in);
        while (true) {            
            try {
                System.out.print("Enter operator: ");
                operator= sc.nextLine();
                if(CheckOperator(operator))
                    return operator;
                else throw new MyException("Please input(+, -, *, /, ^)");
            } catch(MyException e){
                System.out.println(e.getMessage());
            }catch (Exception e) {
            }
        }
        
    }
}
