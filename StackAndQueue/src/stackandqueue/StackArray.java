/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackandqueue;

/**
 *
 * @author 84384
 */
public class StackArray <E>{
    public E[] stackArray;
    public int size= 0;

    public StackArray() {
        stackArray=(E[]) new Object[50];
    }
    public StackArray(int n){
        stackArray=(E[]) new Object[n];
    }
    public boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    }
    public E peek(){
        if(isEmpty()==true)
            return null;
        return stackArray[1];
    }
    public void push(E e){
        ++size;
        stackArray[size]= e;
    }
    
    @Override
    public String toString() {
        String str="";
        if(isEmpty()==true)
            return str;
        System.out.println(size);
        for(int i=size; i>=1; i--)
            str=  stackArray[i].toString()+","+str;
        return str.substring(0, str.length()-1);
    }
    
    public E pop(){
        size--;
        return stackArray[size+1];
    }
    public static void main(String[] args) {
        StackArray test= new StackArray(10);
        test.push(6);
        test.push(5);
        test.push(1);
        test.push(2);
        System.out.println("Stack empty is:"+test.isEmpty());
        System.out.println("toString: "+test.toString());
        test.pop();
        System.out.println("pop: "+test.toString());
        System.out.println("peek: "+test.peek());
    }
}
