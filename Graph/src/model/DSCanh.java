/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84384
 */
public class DSCanh<E> implements Comparable<DSCanh>{
    private E A, B;
    private Comparable<E> length;

    public DSCanh(E A, E B, Comparable<E> length) {
        this.A = A;
        this.B = B;
        this.length = length;
    }

    public E getA() {
        return A;
    }

    public void setA(E A) {
        this.A = A;
    }

    public E getB() {
        return B;
    }

    public void setB(E B) {
        this.B = B;
    }

    public Comparable<E> getLength() {
        return length;
    }

    public void setLength(Comparable<E> length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return ""+A+" " + B+" " + length;
    }

    @Override
    public int compareTo(DSCanh o) {
        return this.length.compareTo((E)o.getLength());
    }
    
}
