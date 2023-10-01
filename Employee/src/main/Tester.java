/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.ArrayList;
import model.*;
public class Tester {
    public static void main(String[] args) {
        ArrayList<Employee> emp= new ArrayList<>();
        emp.add(new StaffContract("Nguyen Anh Viet", "Quảng Ngãi", 100.0, 26, 1.2));
        emp.add(new StaffOffical("Nguyen Van A", "Quang Ninh", 120.0, 25, 2.0, 200));
        emp.add(new StaffContract("Nguyen Anh B", "Quảng Tri", 90.0, 27, 0.9));
        emp.add(new StaffContract("Nguyen Anh C", "Quảng Binh", 130.0, 19, 1.6));
        emp.add(new StaffOffical("Nguyen Van D", "Quang Nam", 170.0, 30, 3.0, 400));
        emp.add(new StaffOffical("Nguyen Van E", "Quang Ninh", 110.0, 23, 1.4, 100));
        for(int i=0; i< emp.size(); i++){
            if(emp.get(i) instanceof StaffContract)
                System.out.println(emp.get(i).getName()+": "+ ((StaffContract)emp.get(i)).salary());
            if(emp.get(i) instanceof StaffOffical)
                System.out.println(emp.get(i).getName()+": "+ ((StaffOffical)emp.get(i)).salary());
        }
    }
}
