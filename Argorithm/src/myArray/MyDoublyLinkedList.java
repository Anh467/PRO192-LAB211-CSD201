/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myArray;

import com.sun.tools.javac.comp.Todo;
import myException.MyException;
public class MyDoublyLinkedList<E> {
    
// node
    public class Node <E>{
        private E info;
        private Node next;
        private Node prev;
        public Node(E a) {
            this.info= a;
            this.next= null;
            this.prev= null;
        }
//constructor
        public Node() {
        }
        public Node(E info, Node next, Node prev) {
            this.info = info;
            this.next = next;
            this.prev = prev;
        }
//get set
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
        public Node getPrev() {
            return prev;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
        }
//toString
        @Override
        public String toString() {
            return "Node{" + "info=" + info + ", next=" + next + ", prev=" + prev + '}';
        }
    }
//het node
    //khai bao lop linklist
    Node<E> head, tail;
    Node p= null;
    int adrress, n=0;
    public Node<E> []a;
    
    public boolean booleanIsEmpty(){
        return (head==null);
    }
    public void clear(){
        head= null;
        tail= null;
    }
 // void
    
    public void add(){
        Node<E> a= new Node<>(), b= new Node<>(), c= new Node<>(), d= new Node<>(), e= new Node<>(), f= new Node<>(), g= new Node<>(), h= new Node<>();
        h= new Node(1, null, g);
        g= new Node(15, h, f);
        f= new Node(-11, g, e);
        e= new Node(17, f, d);
        d= new Node(20, e, c);
        c= new Node(-11, d, b);
        b= new Node(30, c, a);
        a= new Node(40, b, null);
        n= 8;
        head= a;
        tail= h;
    }
    public void addLast(E element){
        Node p= tail;
        Node<E> g= new Node(element, null, p);
        p.setNext(g);
        tail= g;
        n++;
    }
    public void addFrist(E element){
        Node<E> g= new Node(element, head, null);
        head.setPrev(g);
        head= g;
        n++;
    }
    public void addIndex(int x, E element){
        if((x<0)||(x>=n+1))
            System.out.println("out of index"); 
        else if(x==0) addFrist(element);
        else if(x==(n)) addLast(element);
        else{
            
            Node p= head; 
            for(int i= 0; i<x-1; i++)
                p= p.next;
            Node<E> g= new Node(element, p.next,p);
            p.setNext(g);
            p.next.setPrev(g);
            n++;
        }
    }
    @Override
    public String toString() {
        if(booleanIsEmpty()==false){
            String str="";
            Node p= head;
            do{
                str=str+p.info+" ";
                p= p.next;
            }while(p!=null);
            return str;
            }
        return null;
    }
// xoa thanh phan dau va cuoi
    public void removeFirst(){
        try {
            if(booleanIsEmpty()==true) throw new MyException("NoSuchElementException ");
            else{
                // gan diem bat dau la dia chi tiep theo, de xoa phan tu dau tien
                head= head.next;
                n--;
            }
        } catch(MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
        } 
    }
    public void removeLast(){
        try {
            if(booleanIsEmpty()==true) throw new MyException("NoSuchElementException ");
            else{
                tail= tail.prev;
                tail.setNext(null);
                n--;
            }
        } catch(MyException e){
            System.out.println(e);
        }catch (Exception e) {
        } 
    }
// lay gia tri trong linkedList
    public E getFirst(){
        try {
            if(booleanIsEmpty()==true) throw new MyException("NoSuchElementException ");
            else return head.getInfo();
        } catch(MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
        } 
        return null;  
    }
    public E getLast(){
        try {
            if(booleanIsEmpty()==true) throw new MyException("NoSuchElementException ");
            else{
//                Node<E> p= head;
//                for(int i=0; i< n-1; i++)
//                    p= p.next;
                return tail.getInfo();
            }
        } catch(MyException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
        } 
        return null;
    }
    public E get(int index){
        try {
            if((index<0)||(index>=n)) {
                throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
                    
                    }
            else { 
                Node<E> p= head;
                for(int i=0; i< index; i++)
                    p= p.next;
                return p.getInfo();
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
        } 
        return null;
    }
//ddoi gia tri thanh phan
    public void set(int index, E element){
        try {
            if((index<0)||(index>=n)) 
                throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
            else{
                Node<E> p= head;
                for(int i=0; i< index; i++)
                    p= p.next;
                p.setInfo(element);
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (Exception e) {
        } 
    }
// them thanh phan moi

    public void add(E element){
        Node<E> a= new Node<>(element);
        if(n==0){
            head= a;
            a.setNext(null);
            a.setPrev(null);
            n++;
        }
//        else if(n==1){
//            
//        }
        else {
            Node<E> p= head;
            for(int i=1; i< n; i++)
                p= p.next;
            a= new Node(element, null, p);
            p.setNext(a);
            n++;
        }
    }
    public E remove(int index){

        if(index==0){ 
            removeFirst();
            return head.getInfo();
        }
        else if(index==n-1){ 
             Node p= head;
             for(int i=0; i< n-1; i++)
                p= p.next;
             removeLast();
             return (E) p.getInfo();
        }
        else if((index<n)&&(index>0)){
            Node p= head;
            for(int i=0; i< index-1; i++)
                p= p.next;
            Node q= p.next;
            p.setNext(q.next);
            q.setPrev(p);
            n--;
            return( (E) q.getInfo());
        }
        return null;
    }
    public int indexOf(E element){
        Node p= head;
//        if(p.getInfo()== element)
//            return 0;
        for(int i=0; i< n; i++){
            if(p.getInfo()== element)
                return i;
                p= p.next;    
        }
        return -1;
    }
    public int find(E element){
        Node p= head;
//        if(p.getInfo()== element)
//            return 0;
        for(int i=0; i< n; i++){
            if(p.getInfo()== element)
                return i;
                p= p.next;    
        }
        return -1;
    }
    public int lastIndexOf(E element){
        Node p= tail;
//        if(p.getInfo()== element)
//            return 0;
        for(int i=0; i< n; i++){
            if(p.getInfo()== element)
                return i;
                p= p.prev;    
        }
        return -1;
    }
    public boolean remove(E element){
        //System.out.println("hi");
        int i= find(element);
        if(i!=-1){
            remove(i);
            return true;
        }
        return false;
    }
    public boolean contains(E element){
        if(find(element)==-1)
            return false;
        return true;
    }
    public int size(){
        return n;
    }
    public Object[] toArray(){
        int[] a= new int[10];
        E[] arr;
        arr= (E[]) new Object[n];
        Node p= head;
        for(int i=0; i< n; i++){
            arr[i]=(E) p.getInfo();
            p= p.next;
        }
        return arr;
    }
    public static void main(String[] args) {
        MyDoublyLinkedList test= new MyDoublyLinkedList();
        test.add();
        System.out.println(test.toString());
        //test.size()-2
//        test.addLast(7);
//        test.addFrist(1);
        test.addIndex(test.size(), 3);
        System.out.println(test.toString());
        //test.addIndex(test.size()-1, 50);
        test.removeFirst();
        test.removeLast();
        System.out.println("After remove first and last: "+test.toString());
        test.addFrist(-1);
        test.addLast(11);
        System.out.println("After remove first and last: "+test.toString());
        System.out.println("Get first is "+test.getFirst()+". Get last is "+test.getLast());
        System.out.println("Get at 4 is "+test.get(6));
        test.add();
        System.out.println("After add element: "+test.toString());
        test.remove(1);
        System.out.println("After remove element: "+test.toString());
        System.out.println("Contain infor: "+test.contains(40));
        Object[] arr= test.toArray();
        System.out.println("After change to array: ");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }


}
