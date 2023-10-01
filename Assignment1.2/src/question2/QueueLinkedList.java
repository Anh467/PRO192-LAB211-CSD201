/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question2;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class QueueLinkedList <E>{
    public class Node <E>{
        private E info;
        private Node next;
        public Node(E a) {
            this.info= a;
            this.next= null;
        }

        public Node() {
        }

        public Node(E info, Node next) {
            this.info = info;
            this.next = next;
        }

        public E getInfo() {
            return info;
        }

        public void setInfo(E info) {
            this.info = info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
    }
    private int sizeMax;
    Node<E> head;
    int top=-1;

    public QueueLinkedList(int sizeMax) {
        this.sizeMax = sizeMax;
    }
    
    public boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }
    public E element(){  
        try {
            if(isEmpty()==true) throw new NoSuchElementException();
            else return head.getInfo();
        }catch(NoSuchElementException e){
            System.out.println(e);
        }
        catch (Exception e) {
        }
        return null;
    }
    public E peek(){
        if(isEmpty())
            return null;
        return head.getInfo();
    }
    public void remove(){
        try {
            if(isEmpty()==true) throw new EmptyStackException();
            else{
                head= head.next;
                top--;
            }
        }catch(EmptyStackException e){
            System.out.println(e);
        }
        catch (Exception e) {
        }
    }
    public E poll(){
        if(isEmpty())
            return null;
        Node p= head;
        head= head.next;
        top--;
        return (E) p.getInfo();
    }
    public boolean add(E element){
        try {
            if(top+2== sizeMax) throw new IllegalStateException();
            else{
                if(top==-1){
                    Node q= new Node(element, null);
                    head= q;
                    top++;
                }else{
                    Node q= new Node(element, null);
                    Node<E> p= head;
                    for(int i=0; i<top; i++)
                        p= p.next;
                    p.setNext(q);
                    top++;
                }
            return true;
            }
        }catch(IllegalStateException e){
            System.out.println(e);
        }
        catch (Exception e) {
        }
        return false;
    }
    public boolean offer(E element){
        if(top+2== sizeMax)
            return false;
        if(top==-1){
            Node q= new Node(element, null);
            head= q;
            top++;
        }else{
            Node q= new Node(element, null);
            Node<E> p= head;
            for(int i=0; i<top; i++)
                p= p.next;
            p.setNext(q);
            top++;
        }
        return true;
    }

    @Override
    public String toString() {
        String str="";
        Node<E> q= head;
        if(isEmpty()==true)
            return str;
        for(int i=0; i<=top; i++){
            str= str+q.getInfo()+", ";
            q= q.getNext();
        }
        return str.substring(0,str.length()-2);
    }
    public static void main(String[] args) {
        QueueLinkedList test= new QueueLinkedList(5);
        System.out.println("Queue is empty is "+ test.isEmpty());
        test.add(5);
        test.add(1);
        test.add(3);
        test.add(4);
        test.add(7);
        System.out.println(test.toString());
        System.out.println("Queue is empty is "+ test.isEmpty());
        test.remove();
        System.out.println("After dequeue: "+test.toString());
        System.out.println("Font: "+test.element());
        test.remove();
        System.out.println("Queue after remove: "+test.toString());
    }
}
