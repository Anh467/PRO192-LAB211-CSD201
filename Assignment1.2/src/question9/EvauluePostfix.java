/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question9;

import java.util.Stack;

/**
 *
 * @author 84384
 */
public class EvauluePostfix {
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
    public int CalculatePostfix(String str){
        Stack stack= new Stack();
        for(int i=0; i< str.length(); i++)
            if(Character.isDigit(str.charAt(i)))
                stack.push((int)str.charAt(i)-48);
            else{
                int num1, num2;
                switch (str.charAt(i)) {
                    case '+': num1 = (int)stack.pop();
                              num2= (int)stack.pop();
                              stack.push(num2+num1);
                        break;
                    case '-': num1= (int)stack.pop();
                              num2= (int)stack.pop();
                              stack.push(num2-num1);
                        break;
                    case '*': num1= (int)stack.pop();
                              num2= (int)stack.pop();
                              stack.push(num2*num1);
                        break;
                    case '/': num1= (int)stack.pop();
                              num2= (int)stack.pop();
                              stack.push(num2/num1);
                        break;
                    case '^': num1= (int)stack.pop();
                              num2= (int)stack.pop();
                              stack.push(Math.pow(num2, num1) );
                        break;
                    default: break;
                }
                
            }
        return (int)stack.pop();
    }
    public static void main(String[] args) {
        EvauluePostfix control= new EvauluePostfix();
        System.out.println("result: "+control.CalculatePostfix("72*923+*6-+"));
    }
}
