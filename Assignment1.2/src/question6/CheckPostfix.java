/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question6;

import java.util.Stack;

/**
 *
 * @author 84384
 */
public class CheckPostfix {
    public boolean CheckPostfix(String str){
        Stack stack= new Stack();
        for(int i=0; i< str.length(); i++)
            if(Character.isDigit(str.charAt(i))||(Character.isLetter(str.charAt(i))))
                stack.push(str.charAt(i));
            else{
                if(stack.size()==1){
                    System.out.println("invalid, missing an operand");
                    return false;
                }
                stack.pop();
            }
        if(stack.size()==1){ 
            System.out.println("Valid");
            return true;
        }
        if(stack.size()>1){
            System.out.println("invalid, missing an operator");
        }
        if(stack.size()<1){
            System.out.println("invalid, missing an operand");
        }
        return false;
    }
    public static void main(String[] args) {
        CheckPostfix check= new CheckPostfix();
        System.out.println(check.CheckPostfix("ab+-c".trim()));
    }
}
