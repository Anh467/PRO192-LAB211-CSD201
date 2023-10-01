/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import interfaceShape.Shape;
import java.util.Scanner;
import myException.MyException;
public class Rectangle implements Shape{
    private double length, Width;
    @Override
    public double are() {
        return length* Width;
    }

    public Rectangle() {
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
    public void input() {
        double l= getInput("length"), w= getInput("width");
        this.Width= w;
        this.length= l;
    }

    @Override
    public void output() {
        System.out.println("With: "+this.Width+"/ "+"Legth: "+this.length);
    }
    @Override
    public double perimeter() {
        return Width*2 + length*2;
    }
    
}
