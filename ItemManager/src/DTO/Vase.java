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
public class Vase extends Item{
    private int height;
    private String material;

    public Vase(int height, String material, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public Vase() {       
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    public void inputVase(){
        super.input();
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter height:");
            this.height= Integer.parseInt(ip.nextLine());;
          //  ip.nextLine();
        System.out.print("Enter material:");
            this.material= ip.nextLine();
    }   
    public void outputVase(){
        System.out.println("--------------------------");
        super.outPut();
        System.out.println("height :"+this.height);
        System.out.println("material"+this.material);
        
    }
}

