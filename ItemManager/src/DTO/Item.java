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
    protected int value;
    protected String creator;
//contruct
    public Item() {
    }
    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }
//getter&&setter
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
//input
    public void input(){
        do{
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter value  : ");            
            this.value= Integer.parseInt(ip.nextLine());
        System.out.print("Enter creator: ");
            
            this.creator= ip.nextLine();
        }while(this.value>0 && this.creator== null);
    }
    public void outPut(){
     //   System.out.println("-----------------------------------");
        System.out.println("value  : "+ this.value);
        System.out.println("creator: "+ this.creator);
    }
    
}
