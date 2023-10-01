/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package MAN.GUI;
    import MAN.DTO.Item;
    import MAN.DTO.Painting;
    import MAN.DTO.Statue;
    import MAN.DTO.Vase;
    import MAN.DTO.Menu;

public class AntiqueShop {
    public static Item item= null;
   
    
    public static void main(String[] args) {
        int choice;
        do{
        choice= Menu.getUserChoice();

        switch(choice){
            case 1: 
                    item= new Vase();                   
                    ((Vase)item).inputVase();
                    break;
            case 2: item =new Statue();
                    ((Statue) item).inputStatue();
                    break;
            case 3: item =new Painting();
                    ((Painting) item).inputPainting();
                    break;
            case 4: if(item!=null){
                        if(item instanceof Vase)
                            ((Vase) item).outputVase();
                        else if(item instanceof Statue)
                            ((Statue) item).outputStatue();
                        else if(item instanceof Painting)
                            ((Painting) item).outputPaiting();
                        }                  
                    else System.out.println(" you need to create an object");
                    break;   
        }
        }while(choice>=0&& choice<=4);
    }
}

