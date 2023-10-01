/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackandqueue;
import myException.MyException;
public class CricleQueueArray<E> implements Queue{
    public E []a;
    private int n;
    private int head= -1, tail= -1;
    public CricleQueueArray() {
        a= (E[]) new Object[5];
        n= 0;
    } 
    public CricleQueueArray(int capacity){
        if(capacity<0)
            a=(E[]) new Object[capacity];
        else 
            a=(E[]) new Object[capacity];
        n=0;    
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        if(n==0)
            return true;
        return false;
    }
    public boolean isFull() {
        if(n==a.length)
            return true;
        return false;
    }

    @Override
    public E front() {
        try {
            if(isEmpty()) throw new MyException("EmptyQueueException");
            else return a[head]; 
        }catch(MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
        }
        return null;
    }

    @Override
    public void enqueue(Object o) {
        try {
            if(isFull()) throw new MyException("FullQueueException");
        } catch(MyException e){
            System.out.println(e.getMessage());
            return;
        }catch (Exception e) {      
        }
        if(n==0){
            head= 0; tail= 0;
            a[0]=(E) o;
            n++;
        }else{
            if(tail==a.length-1)
                tail=0;
            else tail++;
            a[tail]= (E) o;
            n++;
        }
    }

    @Override
    public Object dequeue() {
        try {
            if(isEmpty()) throw new MyException("EmptyQueueException"); 
        }catch(MyException e){
            System.out.println(e.getMessage());
            return null;
        }catch (Exception e) {
        }
        E draft= a[head];
        if(head==a.length-1)
            head= 0;
        else head++;
        n--;
        return draft;
    }

    @Override
    public String toString() {
        String str="";
        int i=head;
        if(n==0) return str;
        if(n==1) return a[tail].toString();
        do{
            str=str+a[i];
            if(i==a.length-1)
                i= 0;
            else i++;
        }while(a[i]!=a[tail]);
        str= str+a[tail];
        return str;
    }
    public void rotate(){
        if(isEmpty()) return;
        int tailDraft= tail, headDraft= head;
        E draft= a[head];
        a[head]= a[tail];
        a[tail]= draft;
    }
    public static void main(String[] args) {
        CricleQueueArray c= new CricleQueueArray();
        c.dequeue();
        c.enqueue(4);
        c.enqueue(1);
        c.enqueue(7);
        c.enqueue(3);
        System.out.println(c.toString());
        c.rotate();
        System.out.println("rotate: "+c.toString());
        System.out.println("Dequeue:"+ c.dequeue());
        System.out.println(c.toString());
        System.out.println("font: "+c.front());
      }
    
}
