/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question1;

import java.util.Stack;

/**
 *
 * @author 84384
 */
public class ImplementStack {
    public static void main(String[] args) {
        StackLinkedList<Integer> stack= new StackLinkedList<>();
        System.out.println("peek: "+stack.peek());
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(11);
        //test.pop();
        System.out.println(stack.toString());
        System.out.println("peek: "+stack.peek());
        System.out.println("pop: "+stack.pop());
        System.out.println("String after pop: "+stack.toString());
        System.out.println("search: "+stack.search(3));
    }
}
