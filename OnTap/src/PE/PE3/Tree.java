/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PE.PE3;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author 84384
 */
public class Tree {
    class Student implements Comparable<Student>{
        String id, fullname;
        int yearOfBirth;
        double average;
        public Student(String id, String fullname, int yearOfBirth, double average) {
            this.id = id;
            this.fullname = fullname;
            this.yearOfBirth = yearOfBirth;
            this.average = average;
        }

        @Override
        public int compareTo(Student o) {
            return this.id.compareTo(o.id);
        }

        @Override
        public String toString() {
            return  id + " " + fullname + " " + yearOfBirth + " " + average;
        }
        
    }       
    class Node{
        Student infor;
        Node left, right;

        public Node(Student infor) {
            this.infor = infor;
        }

        public Node(Student infor, Node left, Node right) {
            this.infor = infor;
            this.left = left;
            this.right = right;
        }
        
    }
    Node root;
    //1. Write a function that adds 10 students to the BST by student’s id. 
    public void adds(){
        add(new Student("5", "Nguyen Van F", 2003, 7.7)); //19 5
        add(new Student("0", "Nguyen Van A", 2005, 6.8)); 
        add(new Student("6", "Nguyen Van G", 2002, 7.8));
        add(new Student("1", "Nguyen Van B", 2003, 9.8)); //19 1
        add(new Student("9", "Nguyen Van G", 2001, 8.8));
        add(new Student("2", "Nguyen Van C", 2003, 10.0));//19 2
        add(new Student("8", "Nguyen Van I", 2004, 9.8));
        add(new Student("4", "Nguyen Van E", 2005, 4.8));
        add(new Student("7", "Nguyen Van H", 2003, 6.8));// 19 7
        add(new Student("3", "Nguyen Van D", 1996, 5.8)); 
    }
    public void add(Student element){
        if(root==null){
            root= new Node(element);
            return;
        }
        Node r= root;
        while (true) {            
            if(element.compareTo(r.infor)>0) {
                if(r.right== null){
                    r.right= new Node(element);
                    return;
                }
                r= r.right;
                continue;
            } 
            if(element.compareTo(r.infor)<0) {
                if(r.left== null){
                    r.left= new Node(element);
                    return;
                }
                r= r.left;
                continue;
            }
            return;
        }
    }
    //2. Write a function to traverse the tree by level (breath-traversal). 
    //(Hint: Using the isEmpty, add, remove methods of the Queue in Java to write function of question 2).
    public void BFS(){
        if(root== null) return;
        Queue<Node> newQueue= new LinkedList<>();
        newQueue.add(root);
        while(!newQueue.isEmpty()){
            Node p= newQueue.remove();
            if(p==null) continue;
            System.out.print(p.infor.id+" ");
            newQueue.add(p.left);
            newQueue.add(p.right);
        }
    }
    //3. Write a function to traverse the tree in descending order. 
    public void descendingOrder(Node r){
        if(r==null) return;
        descendingOrder(r.right);
        System.out.print(r.infor.id+" ");
        descendingOrder(r.left);
    }
    public void descendingOrder(){
        descendingOrder(root);
    }
    //4. Write a function that counts how many students whose average mark is less than 5
    public int count(Node r){
        if(r ==null) return 0;
        if(r.infor.average< 5) return 1+count(r.left)+count(r.right);
        return count(r.left)+count(r.right);
    }
    public int count(){
        return count(root);
    }
    //5. Write a function that deletes students whose age is 19.
    public Node remove(Node r, Student e){
        if(r==null)
            return r;
        if(r.infor.compareTo((Student)e)>0){
            r.left= remove(r.left, e);
            return r;
        }
        if(r.infor.compareTo((Student)e)<0){
            r.right= remove(r.right, e);
            return r;
        }
    //TH khong co con
        if((r.left==null)&&(r.right==null)){
            r= null;
            return r;
        }
    //th co con trai
        if((r.left!=null)&&(r.right==null)){
            r.infor= r.left.infor;
            r.left= remove(r.left, r.left.infor);
            return r;
        }
    // co con phai
        if((r.left==null)&&(r.right!=null)){
            r.infor= r.right.infor;
            r.right= remove(r.right, r.right.infor);
            return r;
        }
    // co 2 con 
        Node P= r.left;
        while (P.right!=null) 
            P= P.right;
        r.infor= P.infor;
        r.left= remove(r.left, P.infor);
        return r;
        
    }
    Calendar instance = Calendar.getInstance();
    int year = instance.get(Calendar.YEAR);
    public void removeBuyAge19(Node r){
        if(r==null) return;  
        if(year- r.infor.yearOfBirth== 19){ 
            r= remove(root, r.infor);
            removeBuyAge19(r);
            return;
        }
        removeBuyAge19(r.left);
        removeBuyAge19(r.right);
    }
    public void remove(){
        removeBuyAge19(root);
    }

    public static void main(String[] args) {
        Tree newPE3= new Tree();
        newPE3.adds();
        newPE3.BFS();
        
        newPE3.remove();
        System.out.println("");
        newPE3.BFS();
        System.out.println("");
        newPE3.descendingOrder();
    }
}
