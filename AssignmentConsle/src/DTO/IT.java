/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 84384
 */
public class IT extends Student{
private double css, java;
//construct
    public IT(double css, double java) {
        this.css = css;
        this.java = java;
    }

    public IT(double css, double java, String id, String name, String address, String email) {
        super(id, name, address, email);
        this.css = css;
        this.java = java;
    }
//get set
    public double getCss() {
        return css;
    }

    public void setCss(double css) {
        this.css = css;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }
//to String

    @Override
    public String toString() {
        return super.toString()+"/"+css+"/"+ java+"/0";
    }
    

    @Override
    public double ave() {
        return (Math.ceil(((java*3 + css)/4)*100)/100);
    }
    
}
