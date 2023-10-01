/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051.model;

/**
 *
 * @author 84384
 */
public class BMI {
    private double weight, height;

    public BMI() {
    }

    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public String BMIStatus(){
        double BMI= (this.weight)/((this.height*this.height)/10000);
        if(BMI<19)
            return "Under-standard";
        if(BMI<25)
            return "standard";
        if(BMI<30)
            return "Overweight";
        if(BMI<40)
            return "Fat - should lose weight";
        return "Very fat - should lose weight immediately";
    }

    @Override
    public String toString() {
        return BMIStatus();
    }
    
}
