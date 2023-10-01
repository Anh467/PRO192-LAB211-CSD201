/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myArray;
//import model.Node;
import myException.MyException;
public class MyLinkedList<E>{

// node
    public class Node <E>{
        private E info;
        private Node next;

        public Node(E a) {
            this.info= a;
            this.next= null;
        }
        public Node() {

        }
        public Node(E a, Node next) {
            this.info= a;
            this.next= next;
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
            @Override
            public String toString() {
                return "Node{" + "info=" + info + '}';
            }

    }
//het node
    //khai bao lop linklist
    Node<E> head, tail;
    Node p= null;
    int n=0;
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
        Node<E> h= new Node(1);
        Node<E> g= new Node(15, h);
        Node<E> f= new Node(-11, g);
        Node<E> e= new Node(17, f);
        Node<E> d= new Node(20, e);
        Node<E> c= new Node(-11, d);
        Node<E> b= new Node(30, c);
        Node<E> a= new Node(40, b);
        n= 8;
        head= a;
        tail= h;
    }
    public void addLast(E element){
        Node<E> g= new Node(element, null);
        tail.setNext(g);
        tail= g;
        n++;
    }
    public void addFrist(E element){
        Node<E> g= new Node(element);
        g.setNext(head);
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
            for(int i= 1; i< x; i++)
                p= p.next;
            Node<E> g= new Node(element, p.next);
            p.setNext(g);
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
                Node<E> p= head;
                for(int i=0 ;i< n-2; i++)
                    p= p.next;
                p.setNext(null);
                p.next= null;
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
                return tail.getInfo();
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
        Node<E> a= new Node<>(element,null);
        if(n==0){
            head= a;
            n++;
        }
        if(n==1) {
            a= new Node(element, null);
            tail=a;
            head.setNext(a);
            n++;
        }
        else {
            a= new Node(element, null);
            tail.setNext(a);
            tail=a;
            n++;
        }
    }
    public E remove(int index){
        if(index==0){ 
            E p= head.getInfo();
            removeFirst();
            return p;
        }
        else if(index==n-1){ 
            E p= tail.getInfo();
            removeLast();
            return p;
        }
        else if((index<n)&&(index>0)){
            Node p= head;
            for(int i=0; i< index-1; i++)
                p= p.next;
            Node q= p.next;
            p.setNext(q.next);
            n--;
            return( (E) q.getInfo());
        }
        return null;
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
    public boolean remove(E element){
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
    public void reverse(){
        Node h= null;
        tail= head;
        while(head!= null){
            Node p= head.next;
            head.next= h;
            h= head;
            head= p;
        }
        head= h;
        
    }
    public void removeNegative(){
        while((int) head.getInfo()<=0){
            head= head.next;
            n--;
        }
        Node p= head.next;
        Node r= head;
        while(p!= null){
            if((int)p.getInfo()<0){
                p= p.next;
                r.setNext(p);
                n--;
            }
            else{
                p= p.next;
                r= r.next;
            }
        }
        
    }
    public static void main(String[] args) {
        MyLinkedList test= new MyLinkedList();
        test.addFrist(100);
        test.add();
        System.out.println(test.toString());
        //test.size()-2
        test.addIndex(0, 7);
        Object[] arr= test.toArray();
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);
        System.out.println(test.toString());
    }
}
