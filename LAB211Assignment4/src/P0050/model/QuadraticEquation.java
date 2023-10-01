/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0050.model;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class QuadraticEquation extends LinearEquation{
    private double a;
public QuadraticEquation() {
    }
    public QuadraticEquation(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    @Override
    public String toString() {
        return this.a+"x^2+ "+super.getB()+"x+"+super.getC()+"=0" +"\n"+ solve()+"\n"+numberForm();
    }

    @Override
    public String solve() {
        double delta= super.getB()* super.getB()- 4*this.a*super.getC();
        if(Math.abs(delta)<0.0001)
            return "Solution: x1= " +(-super.getB()/(2*this.a))+" and x2="+(-super.getB()/(2*this.a));
        if(delta>0)
            return "Solution: x1= " +((-super.getB()+Math.sqrt(delta))/(2*this.a))+" and x2="+((-super.getB()-Math.sqrt(delta))/(2*this.a));
        return "No Solution";
    }
    @Override
    public String numberForm() {
        String strOdd="", strEven="", strSquare="", str="";
        if (super.checkInt(super.getB())==true){
            if(!checkEven((int) super.getB()))
                strEven= strEven+ super.getB()+", ";
            else strOdd= strOdd+ super.getB()+", ";
            if(super.checkSquare((int) super.getB()))
            strSquare= strSquare + super.getB()+", ";
        }
        if (super.checkInt(super.getC())==true){
            if(((int)super.getC())%2!=0)
                strEven= strEven+ super.getC()+", ";
            else strOdd= strOdd+ super.getC()+", ";
            if(super.checkSquare((int)super.getC()))
            strSquare= strSquare + super.getC()+", ";
        }
        if (super.checkInt(this.a)==true){
            if(!checkEven((int) super.getB()))
                strEven= strEven+ this.a+", ";
            else strOdd= strOdd+ this.a+", ";
            if((super.checkSquare((int)this.a)))
            strSquare= strSquare + this.a+", ";
        }
        return super.getString(strEven, strOdd, strSquare);
    }


    @Override
    public void input() {
        double a;
        while (true) {            
            Scanner sc= new Scanner(System.in);
            try {
                System.out.println("Enter a: ");
                a= sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("!!!NUMBER WRONG FORMAT!!!");
            }
        }
        this.a= a;
        super.input();
    }
    public static void main(String[] args) {
        QuadraticEquation quar= new QuadraticEquation(3, 4, 5);
        quar.input();
        System.out.println(quar.toString());
        
    }
    
}
