
package LAB5A;


public class Student extends Person implements Comment,Comparable<Student>{
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

    public void evalue() {
        if(rate())
            System.out.println("chuc mung ban da dat hoc sinh gioi");
        else
            System.out.println("ban chua dat ddcu");
    }
    public boolean rate(){
        if (this.gpa>8)
            return true;
        return false;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.gpa, o.gpa);     
    }


    }
    
   
    
