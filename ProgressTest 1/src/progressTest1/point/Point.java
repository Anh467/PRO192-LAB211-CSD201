package progressTest1.point;
import java.util.Scanner;
public class Point {
    private double x, y;
//construct
    public Point() {
    }
     public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
//get set
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
//method
    public double distance(Point B){
        return Math.sqrt((this.x-B.getX())*(this.x-B.getX())+(this.y-B.getY())*(this.y-B.getY()));
    }
//ToString

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
//input
    public void inPut(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter point");
            System.out.print("Enter Xa= ");
            this.x= sc.nextDouble();
            System.out.print("Enter Ya= ");
            this.y= sc.nextDouble();
    }

}
