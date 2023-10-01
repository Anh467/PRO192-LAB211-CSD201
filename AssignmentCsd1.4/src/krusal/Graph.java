/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package krusal;

/**
 *
 * @author 84384
 */
public class Graph<E> implements Comparable<Graph>{
    private E a, b, length;

    public Graph() {
    }

    public Graph(E a, E b, E length) {
        this.a = a;
        this.b = b;
        this.length = length;
    }
    
    public E getA() {
        return a;
    }

    public void setA(E a) {
        this.a = a;
    }

    public E getB() {
        return b;
    }

    public void setB(E b) {
        this.b = b;
    }

    public E getLength() {
        return length;
    }

    public void setLength(E length) {
        this.length = length;
    }
    
    @Override
    public String toString() {
        return "("+a+", "+b+")";
    }

    @Override
    public int compareTo(Graph o) {
        return ((int)this.length- (int)o.length);
    }
    
}
