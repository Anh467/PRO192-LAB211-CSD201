/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackandqueue;

import myException.MyException;

/**
 *
 * @author 84384
 */
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
    Node<E> head;
    int top=-1;
    public void clear(){
        top=-1;
        head= null;
    }
    public boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }
    public void enqueue(E e){
        if(top==-1){
            Node q= new Node(e, null);
            head= q;
            top++;
        }else{
            Node q= new Node(e, null);
            Node<E> p= head;
            for(int i=0; i<top; i++)
                p= p.next;
            p.setNext(q);
            top++;
        }
    }
    public void dequeue(){
        try {
            if(isEmpty()==true) throw new MyException("EmptyStackException");
            else{
                head= head.next;
                top--;
            }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
        }
    }
    public E front(){
        return head.getInfo();
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
        QueueLinkedList test= new QueueLinkedList();
        test.enqueue(5);
        test.enqueue(1);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(7);
        System.out.println(test.toString());
        test.dequeue();
        System.out.println("After dequeue: "+test.toString());
        System.out.println("Font: "+test.front());
    }
}
