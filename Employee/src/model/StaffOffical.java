/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84384
 */
public class StaffOffical extends Employee{
    private double salaryCoe, salaryAllow;

    public StaffOffical(String name, String address, double salaryBase, int age, double salaryCoe, double salaryAllow) {
        super(name, address, salaryBase, age);
        this.salaryCoe = salaryCoe;
        this.salaryAllow = salaryAllow;
    }

    public double getSalaryCoe() {
        return salaryCoe;
    }

    public void setSalaryCoe(double salaryCoe) {
        this.salaryCoe = salaryCoe;
    }

    public double getSalaryAllow() {
        return salaryAllow;
    }

    public void setSalaryAllow(double salaryAllow) {
        this.salaryAllow = salaryAllow;
    }
    
    @Override
    public double salary() {
        return super.getSalaryBase()*this.salaryCoe+ this.salaryAllow;
    }

    @Override
    public String toString() {
        return super.toString()+"StaffOffical{" + "salaryCoe=" + salaryCoe + ", salaryAllow=" + salaryAllow + '}';
    }
    
}
