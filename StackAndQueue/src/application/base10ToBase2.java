/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Queue;
import stackandqueue.*;
public class base10ToBase2 {
    public static StackLinkedList<Integer> toStack(int num){
        StackLinkedList<Integer> stack= new StackLinkedList<>();
        while(num>=1){
            if(num%2==0)
                stack.push(0);
            else stack.push(1);
            num= num/2;
        }
        return stack;
    }
    public static void view(StackLinkedList<Integer> stack){
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }
    public static void main(String[] args) {
        view(toStack(111));
    }
}
