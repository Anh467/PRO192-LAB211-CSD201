/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAN.DTO;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Item {
    private int value;
    private String creator;

    public Item() {
    }
    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void input(){
        do{
        Scanner ip= new Scanner(System.in);
        System.out.print("value  : ");
            this.value= Integer.parseInt(ip.nextLine());
        System.out.print("creator: ");
            this.creator= ip.nextLine();
        }while(this.value<1 || this.creator==null);
    }
    public void outPut(){
        System.out.format("%-15s: %d\n", "Value", this.value);
        System.out.format("%-15s: %s\n", "creator", this.creator);
    }
}
