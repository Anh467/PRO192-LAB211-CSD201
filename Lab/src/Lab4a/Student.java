
package Lab4a;


public class Student extends Person{
    private double gpa;

    public Student(String name, int age, String address, double gpa) {
        super(name, age, address);
        this.gpa=gpa;
    }

    public double getGpa() {
        return gpa;
    }
 
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString()+", student" + " gpa= " + gpa ;
    }

    @Override
    public void doing() {
        System.out.println("Learning");
               
    }

    
    }
    
   
    
