
package GUI;

import java.util.Scanner;
import DTO.Item;
import DTO.Painting;
import DTO.Statue;
import DTO.Vase;

public class AntiqueShop {
 public static void main(String[] args){
    Item item=null;
    int Choice=0;
    Scanner sc= new Scanner(System.in);
 do{
    System.out.println("1. Create a Vase:");
    System.out.println("2. Create a Statue:");
    System.out.println("3. Create a Painting:");
    System.out.println("4. Display the Item:");
    System.out.println("Input a choice");
    Choice=sc.nextInt();
 switch(Choice){
        case 1: item= new Vase();
                ((Vase)item).inputVase();
                break;
        case 2: item= new Statue();
                ((Statue) item).inputStatue();
                break;
        case 3: item =new Painting();
                ((Painting) item).inputPainting();
                break;
        case 4:
                if(item!=null){
                    if(item instanceof Vase)
                        ((Vase) item).outputVase();
                    else 
                        if(item instanceof Statue)
                        ((Statue) item).outputStatue();
                    else 
                        if(item instanceof Painting)
                        ((Painting) item).outputPaiting();
                }       
                    else System.out.println("you need to create an object");
                break;
    }
 }while(Choice<=4&& Choice>0);
 }
}