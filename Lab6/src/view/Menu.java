/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 84384
 */
public abstract class Menu<T> {
    protected String text;
    protected ArrayList<T> option;
    
    public Menu(String text, String[] menu) {
        this.text = text;
        option= new ArrayList<>();
        for(String s: menu)
            option.add((T)s);
        
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<T> getOption() {
        return option;
    }

    public void setOption(String[] menu) {
        for(String s: menu)
            option.add((T)s);
    }
    
    public abstract void excute();
    
    public void Display(){
        for(int i=0; i<option.size(); i++)
            System.out.println((i+1)+". "+option.get(i));
    }
    
    public int getSelect(){
        Scanner sc= new Scanner(System.in);
        System.out.println(text);
        System.out.println("---------------------");
        Display();
        System.out.println("---------------------");
        System.out.print("Enter selection..");
        return sc.nextInt();
    }
}
