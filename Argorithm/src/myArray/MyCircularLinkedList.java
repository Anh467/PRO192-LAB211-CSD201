/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myArray;

import myException.MyException;

/**
 *
 * @author 84384
 */
public class MyCircularLinkedList<E>{
        
// node
    public class Node <E>{
        private E info;
        private Node next;
        public Node(E a) {
            this.info= a;
            this.next= null;
        }
//constructor
        public Node() {
        }
        public Node(E info, Node next) {
            this.info = info;
            this.next = next;
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
//toString

        @Override
        public String toString() {
            return "Node{" + "info=" + info + ", next=" + next + '}';
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
        h= new Node(1, a);
        g= new Node(15, h);
        f= new Node(-11, g);
        e= new Node(17, f);
        d= new Node(20, e);
        c= new Node(-11, d);
        b= new Node(30, c);
        a= new Node(40, b);
        n= 8;
        head= a;
        tail= h;
    }
    public void addLast(E element){
        if(n>=2){
            Node<E> g= new Node(element, head);
            tail.setNext(g);
            tail= g;
            n++;
        }
    }
    public void addFrist(E element){
        if(n>=2){
            Node<E> g= new Node(element, head);
            tail.setNext(g);
            head= g;
            n++;
        }
        
    }
    public void addIndex(int x, E element){
        if((x<0)||(x>=n+1))
            System.out.println("out of index"); 
        else if(x==0) addFrist(element);
        else if(x==(n)) addLast(element);
        else{
            Node p= head; 
            int i=0;
            while( i!=x-1){
                i++;
                p=p.next;
            }
            Node<E> g= new Node(element, p.next);
            p.setNext(g);
            n++;
        }
    }
    public void add(E element){
        if(n==0){
            Node<E> a= new Node<>(element);
            head= a;
            tail=a;
            a.setNext(head);
            n++;
        }
        else if(n==1){
            Node<E> a= new Node<>(element, head);
            tail.setNext(a);
            tail= a;
            n++;
        }
        else {
            Node<E> a= new Node(element, head);
            tail.setNext(a);
            tail= a;
            n++;
        }
    }
    @Override
    public String toString() {
        if(booleanIsEmpty()==false){
            String str="";
            Node p= head;
            while(p!=tail){
                str=str+p.info+" ";
                p= p.next;
            }
            str=str+p.info;
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
                tail.setNext(head);
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
                Node p= head;
                while(p.next!= tail)
                    p= p.next;
                p.setNext(head);
                tail= p;
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
            else return tail.getInfo();
            
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
    public E remove(int index){
        System.out.println("hi");
        if(index==0){ 
            E draft= head.getInfo();
            removeFirst();
            return draft;
        }
        else if(index==n-1){ 
            E draft= tail.getInfo();
             removeLast();
             return draft;
        }
        else if((index<n)&&(index>0)){
            Node p= head;
            for(int i=0; i< index-1; i++)
                p= p.next;
            E draft=(E) p.next.getInfo();
            Node q= p.next;
            p.setNext(q.next);
            n--;
            return draft;
        }
        return null;
    }
    public int find(E element){
        Node p= head;
//        if(p.getInfo()== element)
//            return 0;
        int i= 0;
        do{
            if(p.getInfo()==element)
                return i;
            i++;
            p= p.next;
        }while(p!= tail);
        if(p.getInfo()==element)
            return i;
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
    public int indexOf(E element){
        Node p= head;
        int i= 0;
        do{
            if(p.getInfo()==element)
                return i;
            i++;
            p= p.next;
        }while(p!= tail);
        if(p.getInfo()==element)
            return i;
        return -1;
    }
    public int lastIndexOf(E element){
        Node p= head;
        int i= 0;
        int find= -1;
        do{
            if(p.getInfo()==element)
                find = i;
            i++;
            p= p.next;
        }while(p!= tail);
        if(p.getInfo()==element)
            return i;
        return find;
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
        MyCircularLinkedList test= new MyCircularLinkedList();
//        test.add();
//        System.out.println(test.toString());
        //test.size()-2
        test.add(6);
        test.add(5);
        test.add(1);
        test.addLast(7);
        test.addFrist(1);
        System.out.println(test.toString());
        test.removeFirst();
        test.removeLast();
        System.out.println("After remove first and last: "+test.toString());
        test.addIndex(2, 50);
        System.out.println("add index "+test.toString());
        System.out.println("get index 2: "+test.get(2));
        test.set(2, 60);
        System.out.println("After set index: "+test.toString());
        test.addLast(100);
        test.addFrist(100);
        System.out.println("After add first and last: "+test.toString());
        test.remove(6);
        System.out.println("After remove according index: "+test.toString());
        System.out.println("Get first is "+test.getFirst()+". Get last is "+test.getLast());
        System.out.println("Get at 4 is "+test.get(4));
        test.add(11);
        System.out.println("After add element: "+test.toString());
        System.out.println("Find element: "+test.find(11));
        System.out.println("Find index and last index: "+test.indexOf(100)+" "+ test.lastIndexOf(100));
//        test.add();
//        System.out.println("After add element: "+test.toString());
        test.remove(test.size()-2);
        System.out.println("After remove element: "+test.toString());
        System.out.println("Contain infor: "+test.contains(11));
        Object[] arr= test.toArray();
        System.out.println("After change to array: ");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}
