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
public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;
    public Painting() {
    }
    public Painting(int height, int width, boolean isWatercolour, boolean isFramed) {
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }
    
    public void inputPainting(){
        super.input();
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter height:");
            this.height= ip.nextInt();
        System.out.print("Enter width:");
            this.width= ip.nextInt();
            
        System.out.print("Enter isWatercolour:");
            this.isWatercolour= ip.nextBoolean();
        //ip.nextInt();
        System.out.print("Enter isFramed:");
            this.isFramed= ip.nextBoolean();
    }   
    public void outputPaiting(){
        System.out.println("--------------------------");
        super.outPut();
        System.out.println("height: "+this.height);
        System.out.println("width"+this.width);
        System.out.println("isWatercolour: "+this.isWatercolour);
        System.out.println("isFramed"+this.isFramed);
    }
}
