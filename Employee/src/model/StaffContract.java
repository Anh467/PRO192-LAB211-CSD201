/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84384
 */
public class StaffContract extends Employee{
    private double percentQuality;

    public StaffContract(int percentQuality) {
        this.percentQuality = percentQuality;
    }

    public StaffContract( String name, String address, Double salaryBase, int age, double percentQuality) {
        super(name, address, salaryBase, age);
        this.percentQuality = percentQuality;
    }

    public double getPercentQuality() {
        return percentQuality;
    }

    public void setPercentQuality(double percentQuality) {
        this.percentQuality = percentQuality;
    }
    
    @Override
    public double salary() {
        return this.percentQuality* super.getSalaryBase();
    }

    @Override
    public String toString() {
        return super.toString()+"StaffContract{" + "percentQuality=" + percentQuality + '}';
    }
    
}
