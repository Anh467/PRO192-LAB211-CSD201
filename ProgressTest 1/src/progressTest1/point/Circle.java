 package progressTest1.point;
import java.util.Scanner;
import progressTest1.point.Point;
public class Circle implements Shape{
private double radius;
final double pi= 3.14;
//construct
    public Point pt;
    public Circle() {
    }
    public Circle(double radius, Point po) {
        this.radius = radius;
        pt.setX(po.getX());
        pt.setY(po.getY());
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
        return pi* this.radius* this.radius; 
    }

    @Override
    public double peri() {
        return 2* pi* this.radius; 
    }
//input
    public void inPut(){
        Scanner sc= new Scanner(System.in);
        pt.inPut();
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
        if(pt.distance(B.pt)-(B.getRadius()+this.radius)<=0.0001)
            return true;
        return false;
    }
}
