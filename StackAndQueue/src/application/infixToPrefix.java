/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Stack;

public class infixToPrefix {
    public static boolean checkValid(String str){
        Stack<Character> stack= new Stack<>();
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i)=='(')
                stack.push('(');
            else if(str.charAt(i)==')'){
                if(stack.peek()=='(')
                    stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
    public static int priotyOperand(Character operand){
        if((operand=='*')||(operand=='/')||(operand=='^'))
            return 2;
        if((operand=='+')||(operand=='-'))
            return 1;
        return 0;
    }
    public static boolean Operand(Character operand){
        if((operand=='*')||(operand=='/')||(operand=='^')||(operand=='+')||(operand=='-'))
            return true;
        return false;
    }
    public static String infixToPrefix(String str){
        Stack<Character> stack= new Stack<>();
        String profix="";
        for(int i= 0; i< str.length(); i++){
            if((str.charAt(i)>='0')&&(str.charAt(i)<='9')){
                profix= profix + str.charAt(i);
            }
            else if(Operand(str.charAt(i))){
                if(stack.isEmpty())
                    stack.push(str.charAt(i));
                else if(priotyOperand(stack.peek())>=priotyOperand(str.charAt(i))){
                    profix= profix +stack.pop();
                    stack.push(str.charAt(i));
                }
                else stack.push(str.charAt(i));
            }
            else if(str.charAt(i)=='(')
                stack.push(str.charAt(i));
            else if(str.charAt(i)==')'){
                Character k;
                do{
                    k= stack.pop();
                    if(k!='(')
                        profix= profix +k;
                }while(k!='(');
            }
        }
        
        while(!stack.isEmpty())
            profix= profix+ stack.pop();      
        return profix;
    }
    public static void main(String[] args) {
        System.out.println(checkValid("()"));
        System.out.println(infixToPrefix("7*2+9*(2+3)-6"));
    }
}
