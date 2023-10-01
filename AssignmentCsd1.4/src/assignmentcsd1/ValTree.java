/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentcsd1;
import assignmentcsd1.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ValTree <E>{
    public class Node <E>{
    int height;  
    Comparable<E> infor;
    Node<E> left, right;
    public Node(Comparable<E> i) {
        this.infor= i;
        this.left= null;
        this.right= null;
        this.height= 0;
    }
    public Node(Comparable<E> i, Node<E> pre) {
        this.infor= i;
        this.height= 1;
    }
    public Node(Comparable<E> i, Node<E> left, Node<E> right) {
        this.infor= i;
        this.left= left;
        this.right= right;
        this.height= 1;
    }
    public void updateHeight(){
        int l= 0, r= 0;
        if(this.left!= null)
            l= this.left.height;
         if(this.right!= null)
            r= this.right.height;
        this.height= Integer.max(l, r)+1;
    }
    public int checkBalance(){
        int l= 0, r= 0;
        if(this.left!= null)
            l= this.left.height;
        if(this.right!= null)
            r= this.right.height;
        return r- l;
    }
}
    private int size;
    private Node<E> root;
// xuat theo level
    Queue<Node>[] newQueue;
    public void printArcodingDegree(Node<E> x,int prioty){
        newQueue[prioty].add(x);
        if(x.left!=null)
            printArcodingDegree(x.left, prioty+1);
        if(x.right!=null)
            printArcodingDegree(x.right, prioty+1);
    }
    public void printArcodingDegree(){
        if(!isEmpty()){
            int[] j= new int[10];
            newQueue= new LinkedList[height()];
            for(int i= 0; i< newQueue.length; i++)
                newQueue[i]= new LinkedList();
            printArcodingDegree(root, 0);
            for(int i= 0; i< newQueue.length; i++){
                while(!newQueue[i].isEmpty())
                    System.out.print(newQueue[i].poll().infor+" ");
                System.out.println("");
            }
        }
    }
// chieu cao
    public int height(Node<E> x){
        if(x== null) return 0;
        int left, right;
        left= height(x.left);
        right= height(x.right);
        return left>= right ? left+1 : right+1;
    }
    public int height(){
        if(isEmpty()) return 0;
        return height(root);
    }
    public boolean search(Node<E> x, E find){
        boolean check= false;
        if(x!=null){
            if(x.infor.compareTo(find)==0)
                return true;
            else if(x.infor.compareTo(find)<0)
                return search(x.right, find);
            else
                return search(x.left, find);
            
        }
        return false;
    }
    public boolean search(E find){
        return search(root, find);
    }
    public boolean isEmpty(){
        if (root==null) return true;
        return false;
    }
// xoay trai
    Node rotateLeft(Node z) {
        Node<E> p= z.right;
        z.right= p.left;
        p.left= z;
        z.updateHeight();
        p.updateHeight();
        return p;
    }
// xoay phai
    Node rotateRight(Node z) {
        Node<E> p= z.left;
        z.left= p.right;
        p.right= z;
        z.updateHeight();
        p.updateHeight();
        return p;
    }
//can bang
    public Node<E> rebalance(Node<E> z) {
            if(z==null) return null;
            z.updateHeight();
            int balance = z.checkBalance();
            if (balance > 1) {
                if (z.right.checkBalance()>0) 
                    z= rotateLeft(z);
                 else {
                    z.right = rotateRight(z.right);
                    z = rotateLeft(z);
                }
            } else if (balance < -1) {
                if (z.left.checkBalance()<0)
                    z = rotateRight(z);
                else {
                    z.left = rotateLeft(z.left);
                    z = rotateRight(z);
                }
            }
        return z;
    }
//add node
    public Node<E> add(Node<E> r, Comparable<E> e){
        if(r==null){
            r= new Node<E>(e);
            r.updateHeight();
            return r;
        }
        if(e.compareTo((E) r.infor)==0)
            return r;
        if(e.compareTo((E) r.infor)>0){
            r.right= add(r.right, e);
            r= rebalance(r);
            return r;
        }
        r.left= add(r.left, e);
        r= rebalance(r);
        return r;
    }
    public void add(Comparable<E> e){
        root= add(root, e);
    }
//remove node
    public Node<E> remove(Node<E> r, Comparable<E> e){
        if(r==null){
            r= rebalance(r);
            return r;
        }
        if(r.infor.compareTo((E)e)>0){
            r.left= remove(r.left, e);
            r.left= rebalance(r.left);
            return r;
        }
        if(r.infor.compareTo((E)e)<0){
            r.right= remove(r.right, e);
            r.right= rebalance(r.right);
            return r;
        }
    //TH khong co con
        if((r.left==null)&&(r.right==null)){
            r= null;
            r= rebalance(r);
            return r;
        }
    //th co con trai
        if((r.left!=null)&&(r.right==null)){
            r.infor= r.left.infor;
            r.left= remove(r.left, r.left.infor);
            r.right= rebalance(r.right);
            return r;
        }
    // co con phai
        if((r.left==null)&&(r.right!=null)){
            r.infor= r.right.infor;
            r.right= remove(r.right, r.right.infor);
            r.right= rebalance(r.right);
            return r;
        }
    // co 2 con 
        Node<E> P= r.left;
        while (P.right!=null) 
            P= P.right;
        r.infor= P.infor;
        r.left= remove(r.left, P.infor);
        r.left= rebalance(r.left);
        return r;
    }
    public void remove(Comparable<E> e){
        if(!search((E) e)) return;
        root= remove(root, e);
        root= rebalance(root);
    }
    
    public static void main(String[] args) {
        ValTree val= new ValTree();
        val.add(14);
        val.add(11);
        val.add(13);
        val.add(16);
        val.add(2);
        val.add(9);
        val.add(7);
        val.remove(13);
        System.out.println("height: "+val.height());
        System.out.println("print Arcoding Degree: ");
        val.printArcodingDegree();
    }
}
