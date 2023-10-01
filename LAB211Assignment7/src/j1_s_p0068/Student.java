package j1_s_p0068;

public class Student implements Comparable<Student> {

    private String name;
    private String classes;
    private double mark;

    public Student() {
    }

    public Student(String name, String classes, double mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n Classes: %s\n Mark: %f", this.name, this.classes, this.mark);
    }

}
