/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import interfaceShape.Shape;
import java.util.Scanner;
import myException.MyException;

/**
 *
 * @author 84384
 */
public class Triangle implements Shape{
    private double a, b, c;

    public Triangle() {
        input();
    }
    
    public double getInput(String str){
        Scanner sc= new Scanner(System.in);
        double input;
        while(true){
            try {
                System.out.print("Enter "+str+": ");
                input= sc.nextDouble();
                if(input<=0) throw new MyException(str+" must be postitive");
                else break;
            }catch(MyException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
            }
        }
        return input;
    }
    @Override
    public double are() {
        double p= (this.a+this.b+this.c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public boolean check(double a, double b, double c){
        if((a+b)<=c)
            return false;
        if((a+c)<=b)
            return false;
        if((b+c)<=a)
            return false;
        return true;
    }
    @Override
    public void input() {
        double a, b, c;
        while(true){
            a= getInput("First side");
            b= getInput("Second side");
            c= getInput("Third side");
            if(check(a, b, c))
                break;
            else{
                System.out.println("Inappropriate trilogy side, try again:");
            }
        }
        this.a= a;
        this.b= b;
        this.c= c;
    }

    @Override
    public void output() {
        System.out.println("a: "+this.a+", b: "+this.b+", c: "+ this.c);
    }

    @Override
    public double perimeter() {
        return this.a+ this.b+ this.c;
    }
    
}
