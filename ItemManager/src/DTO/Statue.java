/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class Statue extends Item{
    private int weight;
    private String colour;

    public Statue(int weight, String colour, int value, String creator) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public Statue() {
        
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public void inputStatue(){
        super.input();
        Scanner ip= new Scanner(System.in);
        System.out.println("Enter weight:");
            this.weight= ip.nextInt();
        System.out.println("Enter colour:");
            this.colour= ip.nextLine();
    }   
    public void outputStatue(){
        System.out.println("--------------------------");
        super.outPut();
        System.out.println("weight: "+this.weight);
        System.out.println("colour"+this.colour);
        
    }
}
