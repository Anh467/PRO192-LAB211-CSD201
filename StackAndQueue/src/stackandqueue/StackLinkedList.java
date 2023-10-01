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
public class StackLinkedList <E>{
    public class Node <E>{
        private E info;
        private Node prev;
        public Node(E a) {
            this.info= a;
            this.prev= null;
        }
        public Node() {

        }
        public Node(E a, Node prev) {
            this.info= a;
            this.prev= prev;
        }
        public E getInfo() {
            return info;
        }

        public void setInfo(E info) {
            this.info = info;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
        @Override
        public String toString() {
            return "Node{" + "info=" + info + ", prev=" + prev + '}';
        }
    }
    Node<E> tail;
    Node p= null;
    int top=-1;
    public void clear(){
        top=-1;
        tail= null;
    }
    public boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }
    public void push(E e){
        if(top==-1){
            Node q= new Node(e, null);
            tail= q;
            top++;
        }else{
            Node q= new Node(e, tail);
            tail= q;
            top++;
        }
    }
    public E pop(){
        try {
            if(isEmpty()==true) throw new MyException("EmptyStackException");
            else{
                E p= tail.getInfo();
                tail= tail.prev;
                top--;
                return p;
            }
            
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
        }
        return null;
    }
    public E peek(){
        return tail.getInfo();
    }
    public int size(){
        return top+ 1;
    }
    public int search(E element){
        Node<E> q= tail;
        if(isEmpty()==true)
            return -1;
        for(int i=0; i<=top; i++){
            if(element== q.getInfo())
                return top- i;
            q= q.getPrev();
        }
        return -1;
    }
    @Override
    public String toString() {
        String str="";
        Node<E> q= tail;
        if(isEmpty()==true)
            return str;
        for(int i=0; i<=top; i++){
            str= q.getInfo()+", "+str;
            q= q.getPrev();
        }
        return str.substring(0,str.length()-2);
    }
    public static void main(String[] args) {
        StackLinkedList test= new StackLinkedList();
        test.push(5);
        test.push(1);
        test.push(3);
        test.push(7);
        test.push(11);
        //test.pop();
        System.out.println(test.toString());
        System.out.println("peek: "+test.peek());
        System.out.println("pop: "+test.pop());
        System.out.println("String after pop: "+test.toString());
        System.out.println("search: "+test.search(3));
    }
}
