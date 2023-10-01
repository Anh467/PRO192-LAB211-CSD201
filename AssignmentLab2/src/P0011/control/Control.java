/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0011.control;

import java.util.Stack;

/**
 *
 * @author 84384
 */
public class Control {
    public Stack<Integer> decimalToN(int num, int k){
        Stack<Integer> stack= new Stack<>();
        while(num>=1){
            stack.push(num%k);
            num=num/k;
        }
        return stack;
    }
    public void view(Stack<Integer> stack){
        while(!stack.isEmpty()){
            int k= stack.pop();
            if(k<10)
                System.out.print(k);
            else
                System.out.println((char)(55+k));
        }
    }
    public int NToDecimal(String str, int k){
        int s= 0;
        for(int i=0 ; i< str.length(); i++)
            if((str.charAt(i)>='0')&&(str.charAt(i)<='9'))
                s+= ((int) str.charAt(i)-48)*(Math.pow(k, str.length()-i-1));
            else s+= ((int) str.charAt(i)-55)*(Math.pow(k, str.length()-i-1));
        return s;
    }
    public boolean checkString(String str, int base){
        for(int i=0; i<str.length(); i++)
            if((str.charAt(i)>='0')&&(str.charAt(i)<='9')){
                if(((int) str.charAt(i)-48)>=base)
                    return false;
            }
            else if(((int) str.charAt(i)-55)>= base)
                    return false;
        return true;
    }
    public void main(String[] args) {
        view(decimalToN(111, 16));
        System.out.println(NToDecimal("6F", 16));
    }
}
