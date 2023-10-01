/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059.model;

/**
 *
 * @author 84384
 */
public class Person {
    private String name, address;
    private Double money;

    public Person(String name, String address, Double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void view(){
        System.out.format("%-15s%-20s%-10f\n", name, address, money);
    }
}
