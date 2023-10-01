/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question4;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author 84384
 */
public class Implement {
    
    public static int getInput(String str){
        int num;
        Scanner sc= new Scanner(System.in);
        
        while(true){
            try {
                System.out.println(str);
                int n= sc.nextInt();
                if((n<=1)||(n>16)) throw new MyException("Inappropriate input, try again:");
                else{
                    num= n;
                    break;
                }
            } catch (MyException e){
                System.out.println(e.getMessage());
            }
                catch (Exception e) {
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Convert control= new Convert();
        int baseNumberInput= getInput("choose the base number input ( example 2 is binary, 10 is decimal,  16 is hexadecimal): ");
        int baseNumberOutput= getInput("choose the base number output ( example 2 is binary, 10 is decimal,  16 is hexadecimal):");
        String numEnter;
        Scanner sc= new Scanner(System.in);
            while(true){
            try {
                System.out.print("Enter input value: ");
                numEnter= sc.nextLine();
                if(!control.checkString(numEnter, baseNumberInput)) throw new MyException("Inappropriate input, try again:");
                else break;
            }catch (MyException e) {
                System.out.println(e.getMessage());
            } 
            catch (Exception e) {
            }
        }
        while(numEnter.charAt(0)=='0')
            numEnter= numEnter.substring(1);
        numEnter= numEnter.toUpperCase();
        Stack<Integer> stack= control.decimalToN(control.NToDecimal(numEnter, baseNumberInput), baseNumberOutput);
        System.out.print("Number output: ");
        control.view(stack);
    }
}