
package model;

import java.io.Serializable;

public class Student extends Person implements Serializable{
    private String student_ID, student_email, student_HB;
    private double student_ave;
//construct
    public Student() {
    }

    public Student(String student_ID, String student_email, double student_ave) {
        this.student_ID = student_ID;
        this.student_email = student_email;
        this.student_ave = student_ave;
    }

    public Student(String student_ID, String student_email, double student_ave, String person_name, String person_address, String person_birth, boolean person_gender) {
        super(person_name, person_address, person_birth, person_gender);
        this.student_ID = student_ID;
        this.student_email = student_email;
        this.student_ave = student_ave;
    }
    

//get set
    public String getStudent_HB() {
        return student_HB;
    }

    
    public void setStudent_HB(String student_HB) {    
        this.student_HB = student_HB;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public double getStudent_ave() {
        return student_ave;
    }

    public void setStudent_ave(double student_ave) {
        this.student_ave = student_ave;
    }
//to String

    @Override
    public String toString() {
        return super.toString() + "/" + student_ID + "/" + student_email + "/" + student_ave;
    }
//ktra hoc bong
    public void hoc_bong(){
        if(this.student_ave>= 8)
            this.student_HB="duoc hoc bong";
        else this.student_HB="khong duoc hoc bong";
    }
}
