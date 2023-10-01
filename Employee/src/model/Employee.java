/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84384
 */
public abstract class Employee {
    private String name, address;
    private Double salaryBase;
    private int age;

    public Employee() {
    }

    public Employee(String name, String address, Double salaryBase, int age) {
        this.name = name;
        this.address = address;
        this.salaryBase = salaryBase;
        this.age = age;
    }

    public Double getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(Double salaryBase) {
        this.salaryBase = salaryBase;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public abstract double salary();

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", address=" + address + ", salaryBase=" + salaryBase + ", age=" + age + '}';
    }
    
}
