/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author 84384
 */
public class Question2 {
// dao nguoc queue dung stack
    static Stack<Integer> newStack= new Stack<>();
    static Queue<Integer> newQueue= new LinkedList<>();
    public static void reQueue(){
        while (!newQueue.isEmpty())
            newStack.add(newQueue.poll());

        while (!newStack.isEmpty())
            newQueue.add(newStack.pop());
    }
    public static void addStack(){
        if(!newQueue.isEmpty()){
            newStack.add(newQueue.poll());
            addStack();
        }
    }
    public static void addQueue(){
        if(!newStack.isEmpty()){
            newQueue.add(newStack.pop());
            addQueue();
        }
    }
    public static void reCuQueue(){
        addStack();
        addQueue();
    }
    public static String reNum(int n){
        if(n==0) return "";
        int m= n%10;
        return Integer.toString(m)+ reNum(n/10);
    }
//lam them bubble, insertion sort, selection sort, quicksort
    public static void main(String[] args) {
        newQueue.add(1);
        newQueue.add(2);
        newQueue.add(3);
        newQueue.add(7);
        newQueue.add(11);
        newQueue.add(5);
        reCuQueue();
        while (!newQueue.isEmpty()) {            
            System.out.println(newQueue.remove());
        }
        System.out.println(Integer.parseInt(reNum(321)));
            

    }
}

