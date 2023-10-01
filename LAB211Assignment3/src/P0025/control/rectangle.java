/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0025.control;

/**
 *
 * @author 84384
 */
public class rectangle {
    private double a, b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    public void input(){
        
    }
    public double calculateArea(){
        return a*b;
    }
    public double calculatePer(){
        return 2*(a+b);
    }

    @Override
    public String toString() {
        return "rectangle{" + "a=" + a + ", b=" + b + '}';
    }
    
}
