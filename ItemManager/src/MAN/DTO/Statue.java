
package MAN.DTO;

import java.util.Scanner;

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
        System.out.print("Enter weight: ");
            this.weight= Integer.parseInt(ip.nextLine());
        System.out.print("Enter colour: ");
            this.colour= ip.nextLine(); 
    }
    public void outputStatue(){
        System.out.println("--------------------------");
        super.outPut();
        System.out.format("%s: %d\n", "weight", this.weight);
        System.out.format("%s: %s\n", "colour", this.colour);        
    } 
}
