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
public class Circle implements Shape{
    private double radius;

    public Circle() {
        input();
    }
    
    @Override
    public double are() {
        return this.radius* this.radius* 3.14;
    }

    @Override
    public void input() {
        double r;
        Scanner sc= new Scanner(System.in);
        
        while(true){
            try {
                System.out.print("Enter radius: ");
                r= sc.nextDouble();
                if(r<=0) throw new MyException("radius must be postitive");
                else break;
            }catch(MyException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
            }
        }
        this.radius= r;
    }

    @Override
    public void output() {
        System.out.println("Radius: "+this.radius);
    }
    

    @Override
    public double perimeter() {
        return 3.14* this.radius;
    }
    
}
