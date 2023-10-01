/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question5;

import java.util.Stack;

/**
 *
 * @author 84384
 */
public class checkValid {
    public boolean checkValid(String str){
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
}
