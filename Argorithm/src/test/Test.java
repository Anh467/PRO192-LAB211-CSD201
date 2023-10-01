
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import myArray.MyLinkedList;
import myArray.MyArrayList;
import model.*;
public class Test {
    public static void main(String[] args) {
        
        
        MyLinkedList test= new MyLinkedList();
        test.add();
        System.out.println(test.toString());
        test.remove(3);
        System.out.println(test.toString());
        Object[] arr=  test.toArray();
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);
        System.out.println(test.toString());
        //test.addLast((Integer) new Node(7));
        System.out.format("%-14d and %-13d", 5, 7);
    }
}
