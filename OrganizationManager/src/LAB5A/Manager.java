
package LAB5A;

public class Manager extends Teacher{
    private double bonus;

    public Manager( String name, int age, String address, double salary, double bonus) {
        super(name, age, address, salary);
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary()+this.bonus;
    }
    

    @Override
    public String toString() {
        return (super.toString()+" , bonus: "+ bonus+"$, ToTal salary: "+getSalary()+"$");
    }
    
    
    
}
