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
public class LinearEquation {
    protected double b, c;
public LinearEquation() {
    }
    public LinearEquation(double b, double c) {
        this.b= b;
        this.c= c;
    }
    public void input(){
        double b, c;
        while (true) {            
            Scanner sc= new Scanner(System.in);
            try {
                System.out.println("Enter b: ");
                b= sc.nextDouble();
                System.out.println("Enter c: ");
                c= sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("!!!NUMBER WRONG FORMAT!!!");
            }
        }
        this.b= b;
        this.c= c;
    }
    public String solve(){
        if((b==0)&&(c==0))
            return "!!!INFINITE SOLUTION!!!";
        if((b==0)&&(c!=0))
            return "!!!NO SOLUTION!!!";
        return "SOLUTION: x="+ (-c/b);
    }
    public boolean checkInt(double number){
        int draft= (int) number;
        if(Math.abs(number- draft)<0.0001)
            return true;
        return false;
    }
    public boolean checkEven(int x){
        if(x%2!=0)
            return true;
        return false;
    }
    public boolean checkSquare(int x){
        if(((int)(Math.sqrt(x))*((int)Math.sqrt(x)))==x)
                return true;
        return false;
    }
    public String getString(String strEven, String strOdd, String strSquare){
        String str="";
        if(!strEven.equalsIgnoreCase(""))
            str=str+"Number is Odd: "+strEven.substring(0,strEven.length()-2)+"\n";
        if(!strOdd.equalsIgnoreCase(""))
            str=str+"Number is even: "+strOdd.substring(0,strOdd.length()-2)+"\n";
        if(!strSquare.equalsIgnoreCase(""))
            str=str+"Number is Perfect square: "+strSquare.substring(0,strSquare.length()-2)+"\n";
        return str;
    }
    public String numberForm(){
        String strOdd="", strEven="", strSquare="";
        
        if (checkInt(this.b)==true){
            if(!checkEven((int) this.b))
                strEven= strEven+ this.b+", ";
            else strOdd= strOdd+ this.b+", ";
            if(checkSquare((int)this.b))
            strSquare= strSquare + this.b+", ";
        }
        if (checkInt(this.c)==true){
            if(((int)this.c)%2!=0)
                strEven= strEven+ this.c+", ";
            else strOdd= strOdd+ this.c+", ";
            if(checkSquare((int)this.c))
            strSquare= strSquare + this.c+", ";
        }
        
        return getString(strEven, strOdd, strSquare);
    }
    
    @Override
    public String toString() {
        return this.b+"x+"+this.c+"=0"+"\n"+solve()+"\n"+numberForm();
    }
//get set
    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public static void main(String[] args) {
        LinearEquation line= new LinearEquation(2, 5);
        line.input();
        System.out.println(line.toString());
        
    }
}
