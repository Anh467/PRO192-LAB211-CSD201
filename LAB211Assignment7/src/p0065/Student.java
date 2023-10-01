package p0065;

public class Student {
 private String studentName;
    private String className;
    private double math;
    private double physical;
    private double chemistry;

    public Student() {
    }

    public Student(String studentName, String className, double math, double physical, double chemistry) {
        this.studentName = studentName;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return (this.chemistry+this.math+this.physical)/3;
    }

    public char getType() {
        double average=(this.chemistry+this.math+this.physical)/3;
        if (average > 7.5) 
            return 'A';
        if (average >= 6 && average <= 7.5) 
            return 'B';
        if (average >= 4 && average < 6) 
            return 'C';
        return 'D';
    }
    public void view(int i){
        System.out.println("------ Student"+i+" Info ------");
        System.out.println("Name   : "+this.studentName);
        System.out.println("Classes: "+this.className);
        System.out.println("AVG    : "+getAverage());
        System.out.println("Type   : "+getType());
    }
    @Override
    public String toString() {
        return   studentName +"|"+ className  + "|"+math  + "|"+physical +"|"+chemistry;
    }

   
}
