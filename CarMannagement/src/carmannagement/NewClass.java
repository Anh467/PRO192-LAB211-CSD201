/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carmannagement;

/**
 *
 * @author 84384
 */
import carmannagement.CarMannagement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
public class NewClass{
    public static void main(String[] args) {
        CarMannagement car= new CarMannagement();
        System.out.println(car.toString());
        ArrayList<CarMannagement> carr= new ArrayList<>();
        String[] arr = new String[carr.size()];
    arr= new carr.toArray();

        carr.add(new CarMannagement());
        Collections.sort(carr);
        Collections.sort(carr, new Comparator<CarMannagement>() {
            @Override
            public int compare(CarMannagement o1, CarMannagement o2) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        Arrays.sort(arr);
    }
}
