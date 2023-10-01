/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentcsd1;

/**
 *
 * @author 84384
 */
public class Node <E>{
    Comparable<E> infor;
    Node<E> left, right;
    public Node(Comparable<E> i) {
        this.infor= i;
        this.left= null;
        this.right= null;
    }
    public Node(Comparable<E> i, Node<E> left, Node<E> right) {
        this.infor= i;
        this.left= left;
        this.right= right;
    }
}

