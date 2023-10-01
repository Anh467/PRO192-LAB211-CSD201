/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1.newpackage;

import java.util.Scanner;

/**
 *
 * @author 84384
 */
public class func {
    private String name;
    private double score;
    private String type;
    public func(){
        
    }
    public func(String name, double score, String type){
        setName(name);
        setScore(score);
        setType(type);
    }
//SETTER
    void setName(String name){
        this.name= name;
    }
    void setScore(double score){
        this.score= score;
    }
    void setType(String type){
        this.type= type;
    }
//GETTER
    String getName(){
        return this.name;
    }
    double getScore(){
        return this.score;
    }
    String getType(){
        return this.type;
    }
//GETCHOICE
    public int getUserChoice(){
        int choice;
        Scanner ip= new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("Press 1 enter full name: ");
        System.out.println("Press 2 enter score:");
        System.out.println("Press 3 export data");
        System.out.println("Press 4 sort students by score");
        System.out.println("Press 5 sort the list of students down score by score,");
        System.out.print("Choice: ");
        choice= ip.nextInt();
        return choice;
    }
    public void printOut(){
        System.out.format("Name: %-15s Score: %-15.2f Type: %15s\n",this.name, this.score, this.type);
    }
    public String calType(){
        if(this.score<5)
            return "Weak";
        if(this.score>= 5 && this.score< 6.5)
            return "Average";
        if(this.score>= 6.5 && this.score< 7.5)
            return "Good";
        if(this.score>= 7.5 && this.score< 9)
            return "Excellent";
        if(this.score>= 9)
            return "Super Excellent";
        return null;
    }
}
