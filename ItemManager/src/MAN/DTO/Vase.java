
package MAN.DTO;

import java.util.Scanner;

public class Vase extends Item{
    private int height;
    private String material;

//    public Vase(int value, String creator) {
//        super(value, creator);
//    }
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
        System.out.print("height: ");
            this.height= Integer.parseInt(ip.nextLine());
        System.out.print("material: ");
            this.material= ip.nextLine(); 
    }
    public void outputVase(){
        System.out.println("----------------------------");
        super.outPut();
        System.out.format("%s: %d\n", "height", this.height);
        System.out.format("%s: %s\n", "creator", this.material);
    }

}
