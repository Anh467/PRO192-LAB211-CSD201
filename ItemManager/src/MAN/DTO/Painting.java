
package MAN.DTO;

import java.util.Scanner;

public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public Painting() {
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
        System.out.print("height: ");
            this.height= ip.nextInt(); //Integer.parseInt(ip.nextLine());
        System.out.print("width: ");
            this.width= ip.nextInt(); 
        System.out.print("isWatercolour: ");
            this.isWatercolour= ip.nextBoolean();
        System.out.print("isIsFramed: ");
            this.isFramed= ip.nextBoolean(); 
    }
    public void outputPaiting(){
        System.out.println("----------------------------");
        super.outPut();
        System.out.format("%s: %d\n", "height", this.height);
        System.out.format("%s: %d\n", "width", this.width);
        System.out.println("isWatercolour              :"+this.isWatercolour);
        System.out.println("isIsFramed                 :"+this.isFramed);
    }
}
