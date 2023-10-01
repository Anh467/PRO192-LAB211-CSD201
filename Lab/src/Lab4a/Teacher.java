
package Lab4a;

public class Teacher extends Person implements Comment{
    protected double salary;

    public Teacher(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+", teacher:" + " salary= " + salary+"$" ;
    }

    @Override
    public void doing() {
        System.out.println("Teaching"); 
        
    }

    @Override
    public boolean rate() {
        if(this.getAge()>60) return true;
        else return false;
    }

    @Override
    public void evalue() {
        if(rate())
            System.out.println("chuc mung ban du tuong nghi huu");
        else
            System.out.println("chua du tuoi nghi huu");
    }

//    @Override
//    public int compareTo(Teacher o) {
//        return Double.compare(this.salary, o.salary);
//    }

    

    
    
}
