/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentcsd1;

import java.util.LinkedList;
import java.util.Queue;
import java.lang.reflect.Array;
import java.util.Stack;
/**
 *
 * @author 84384
 */
public class PriorityQueue<E extends Comparable>{
    private E[] arr;  
    int size;
    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }
    public PriorityQueue(Class<E[]> clazz) {  
        arr = clazz.cast(Array.newInstance(clazz.getComponentType(), 100));  
        size= 0;
    } 
        public int height(Integer x){
        if(arr[x]==null) return 0;
        int left, right;
        left= height(2*x+1);
        right= height(2*x+2);
        return left>= right ? left+1 : right+1;
    }
    public int height(){
        if(isEmpty()) return 0;
        return height(0);
    }
    Queue<Integer>[] newQueue;
    public void printArcodingDegree(Integer x,int prioty){
        newQueue[prioty].add(x);
        if(arr[2*x+1]!=null)
            printArcodingDegree(2*x+1, prioty+1);
        if(arr[2*x+2]!=null)
            printArcodingDegree(2*x+2, prioty+1);
    }
    public void printArcodingDegree(){
        if(!isEmpty()){
            int[] j= new int[10];
            newQueue= new LinkedList[height()];
            for(int i= 0; i< newQueue.length; i++)
                newQueue[i]= new LinkedList();
            printArcodingDegree(0, 0);
            for(int i= 0; i< newQueue.length; i++){
                while(!newQueue[i].isEmpty())
                    System.out.print(arr[newQueue[i].poll()]+" ");
                System.out.println("");
            }
        }
    }
    public void fixParent(Integer n){
        if((n-1)/2<0) return;
        if(arr[n].compareTo(arr[(n-1)/2])<0){
            E temp= arr[n];
            arr[n]= arr[(n-1)/2];
            arr[(n-1)/2]= temp;
        }else return;
        fixParent((n-1)/2);
    }
    public void fixChildren(Integer n){
        System.out.println("n="+ n);
        if(n>size-1) return;
        if(arr[n]==null) return;  
        if((arr[2*n+1]!=null)&&(arr[2*n+2]!=null)){
        if((arr[n].compareTo((E)arr[2*n+1])<0)&&(arr[n].compareTo((E)arr[2*n+2]))<0) return;
        if((arr[2*n+1].compareTo((E)arr[n])<0)&&(arr[2*n+1].compareTo((E)arr[2*n+2]))<0){
            System.out.println("left");
            E temp= arr[n];
            arr[n]= arr[2*n+1];
            arr[2*n+1]= temp;
            fixChildren(2*n+1);
            return;
        }
        System.out.println("right");
        E temp= arr[n];
        arr[n]= arr[2*n+2];
        arr[2*n+2]= temp;
        fixChildren(2*n+2);
        }
    }
    public void add(E e){
        arr[size]= e;
        int n= size;
        size++;
        fixParent(n);
    }
    public int search(E e){
        for(int i=0; i< size; i++)
            if(arr[i].compareTo(e)==0) return i;
        return -1;
    }
    public void remove(E e){
        int getIndex= search(e);
        if(getIndex==-1) return;
        arr[getIndex]= arr[size-1];
        arr[size-1]=null;
        size--;
        if(getIndex>size-1) return;
        if(arr[getIndex].compareTo(arr[(getIndex-1)/2])<0)
            fixParent(getIndex);
        else fixChildren(getIndex);
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> newPQ= new PriorityQueue<Integer>(Integer[].class);
        newPQ.add(7);
        newPQ.add(2);
        newPQ.add(5);
        newPQ.add(1);
        newPQ.add(3);
        newPQ.add(4);
        newPQ.add(11);
        newPQ.printArcodingDegree();
        //newPQ.remove(11);
        newPQ.remove(3);
        newPQ.remove(2);
        newPQ.remove(11);
        newPQ.remove(5);
        newPQ.remove(4);
        newPQ.remove(1);
        //newPQ.remove(4);
        //newPQ.remove(4);
        newPQ.printArcodingDegree();
        
    }
}
