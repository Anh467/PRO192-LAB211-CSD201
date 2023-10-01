/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Calendar;
import java.util.Arrays;
class employee implements Comparable<employee>{
    int id; String fullName;
    double salary;
    int yearOfBirth;
    public employee() {
    }
    public employee(int id, String fullName, double salary, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName.trim();
        this.salary = salary;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "employee{" + "id=" + id + ", fullName=" + fullName + ", salary=" + salary + ", yearOfBirth=" + yearOfBirth + '}';
        //"employee{" + "id=" + id + ", fullName=" + fullName + ", salary=" + salary + ", yearOfBirth=" + yearOfBirth + '}'
    }
    
    @Override
    public int compareTo(employee o) {
        if(this.fullName.substring(this.fullName.lastIndexOf(" ")+1, this.fullName.length()).compareTo(o.fullName.substring(o.fullName.lastIndexOf(" ")+1, o.fullName.length()))!=0)
             return(this.fullName.trim().substring(this.fullName.lastIndexOf(" ")+1, this.fullName.length()).compareTo(o.fullName.substring(o.fullName.lastIndexOf(" ")+1, o.fullName.length())));
        if(this.fullName.substring(0, this.fullName.lastIndexOf(" ")).compareTo(o.fullName.substring(0, o.fullName.lastIndexOf(" ")))!=0)
                return (this.fullName.substring(0, this.fullName.lastIndexOf(" ")).compareTo(o.fullName.substring(0, o.fullName.lastIndexOf(" "))));
        return this.id-o.id;
    }

}
public class Question1 {
    public class Node {
        employee infor;
        Node left, right;
        int level;                  
        public Node(employee infor) {
            this.infor= infor;
            this.left= null;
            this.right= null;
        }
        public Node(employee infor, Node left, Node right) {
            this.infor= infor;
            this.left= left;
            this.right= right;
        }
    }
    Node root;
    private Node add(Node r, employee e){
        if(r==null){
            r= new Node((employee) e);
            return r;
        }
        if(e.compareTo((employee) r.infor)==0){
            System.out.println("da co trong du lieu");
            return r;
        }
        if(e.compareTo((employee) r.infor)>0){
            r.right= add(r.right, e);
            return r;
        }
        r.left= add(r.left, e);
        return r;
    }
    public void add(employee e){
        root= add(root, e);
    }
    public void inOrder(Node x){
        if(x!=null){
            inOrder(x.left);
            System.out.println(x.infor+" ");
            inOrder(x.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    public int count(Node r){
        if(r== null) return 0;
        if(r.infor.salary>10) return 1 +count(r.left)+ count(r.right);
        return count(r.left)+ count(r.right);
    }
    public void count(){
        System.out.println("count salaray >10: "+count(root));
    }
    public double countSalary(Node r, int year){
        if(r==null) return 0;
        if(year-r.infor.yearOfBirth>=0) 
            return 1+ countSalary(r.left, year)+ countSalary(r.right, year);
        return countSalary(r.left, year)+ countSalary(r.right, year);
    }
    public double sumEmpSalary(Node r, int year){
        if(r==null) return 0;
        if(year-r.infor.yearOfBirth>=0) 
            return r.infor.salary+ sumEmpSalary(r.left, year)+ sumEmpSalary(r.right, year);
        return sumEmpSalary(r.left, year)+ sumEmpSalary(r.right, year);
    }
    public void avg(){
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        ;
        System.out.println("sum: "+sumEmpSalary(root, year)/countSalary(root, year));
    }
    public Node remove(Node r, employee e){
//        if(r==null)
//            return r;
//        if(r.infor.compareTo((employee)e)>0){
//            r.left= remove(r.left, e);
//            
//            return r;
//        }
//        if(r.infor.compareTo((employee)e)<0){
//            
//            r.right= remove(r.right, e);
//            return r;
//        }
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
    public int size(Node r){
        if(r== null) 
            return 0;
        return 1 +size(r.left)+ size(r.right);
    }
    public int size(){
        return size(root);
    }
    //canh1
    public void remove(Node r, int id){
        if(r==null) return;  
        if(r.infor.id== id) r= remove(r, r.infor);
        remove(r.right, id);
        remove(r.left, id);
    }
//    public void remove(Node r, int id){
//        if(r==null) return;
//        remove(r.left, id);
//        if(r.infor.id== id) remove(r, r.infor);
//        remove(r.right, id);
//    }
    public void remove(int id){
        remove(root, id);
    }
    
//xap xep
    employee []emp; int n;
    public void toArray(Node x){
        if(x!=null){
           
            toArray(x.left);
             emp[n++]= x.infor;
            toArray(x.right);
        }
    }
    public void toArray(){
        emp= new employee[size()];
        toArray(root);
    }
    public void printArcordingSalary(){
        toArray();
        for(int i=0 ; i< emp.length; i++)
                for(int j=0 ; j< emp.length; j++)
                    if(emp[i].salary < emp[j].salary){
                        employee empDraft= emp[i];
                        emp[i]= emp[j];
                        emp[j]= empDraft;
                    }
        for(int i=0 ; i< emp.length; i++)
            System.out.println("a["+i+"]= "+emp[i].toString());
        
    }
    public static void main(String[] args) {
        Question1 bts= new Question1();
        bts.add(new employee(1, "Nguyen Hong Linh", 10, 2002));
        bts.add(new employee(2, "Nguyen Hoang Anh", 11, 2003));
        bts.add(new employee(3, "Mai Hoang Anh", 12, 2001));
        bts.add(new employee(4, "Thanh Dat", 13, 2004));
        bts.add(new employee(5, "Ngo Diep Hoang", 14, 2003));
        bts.add(new employee(6, "Thanh Dat", 7, 2004));
        //bts.inOrder();
        bts.count();
        bts.avg();
        System.out.println("size: "+bts.size());
//        bts.remove(1);
//        bts.remove(3);
//        bts.remove(5);
        bts.inOrder();
        System.out.println("printArray");
        bts.printArcordingSalary();
    }
}
