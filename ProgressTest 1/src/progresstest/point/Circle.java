 package progresstest.point;
import java.util.Scanner;
public class Circle extends point implements Shape{
private double radius;
//construct
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, double x, double y) {
        super(x, y);
        this.radius = radius;
    }
//get set
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }   
//overide
    @Override
    public double area() {
        return 3.14* this.radius* this.radius; 
    }

    @Override
    public double peri() {
        return 2* 3.14* this.radius; 
    }
//input
@Override
    public void inPut(){
        Scanner sc= new Scanner(System.in);
        super.inPut();
        System.out.println("Enter radius: ");
        this.radius= sc.nextDouble();
    }
//to String
    @Override
    public String toString() {
        return super.toString()+"-"+this.radius;
    }   
//checkCircle
    public boolean checkCir(Circle B){
        if((super.distance(B)-(B.getRadius()+this.radius))<= 0.0001)
            return true;
        return false;
    }
}
