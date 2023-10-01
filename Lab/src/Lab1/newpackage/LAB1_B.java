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
public class LAB1_B {
    static func funRun= new func();
    static func[] infor= new func[200];
    static int n=0;
    public static int checkStudent(String draftName){
        for(int i=1; i<= n; i++){
            //infor[i]= new func();
            //System.out.println("check: "+infor[i].getName()+ draftName);
            if(draftName.equalsIgnoreCase(infor[i].getName())==true)
                return i;
        }
        return 0;
    }
    public static void accName(){
        Scanner ip= new Scanner(System.in);
        System.out.print("Enter student "+(n+1)+": ");
        String draftName;
        draftName= ip.nextLine();
        if (checkStudent(draftName)!= 0){
            System.out.println("!!!Student with "+draftName+" already in list!!!");
            n--;
        }
        else{
            n++;
            infor[n]= new func();
            infor[n].setName(draftName);
            System.out.println("!!!add successfull!!!");
        }
    }
    public static void accScore(){
        Scanner ip= new Scanner(System.in);
        String draftName;
        System.out.print("Enter name need to add score:");
        draftName= ip.nextLine();
        int check, draft;
        check= checkStudent(draftName);
        if(check== 0)
            System.out.println("we dont have information about "+draftName);
        else{
            System.out.print("Enter score for "+draftName+":");
            draft= ip.nextInt();
            infor[check].setScore(draft);
            System.out.println("!!!ADD successfull!!!");
        }
        
    }
    public static void printOut(){
        System.out.println("Print out all list:");
        for(int i=1; i<=n; i++)
            infor[i].printOut();
        System.out.println("!!!Successfull!!!");
    }
    public static void calType(){
        for(int i=1; i<= n; i++)
            infor[i].setType(infor[i].calType());
    }
    public static void sortList(){
        for(int i= 1; i< n; i++)
           for(int j= i+1; j<= n; j++){
                double a, b;
                a= infor[i].getScore();
                b= infor[j].getScore();
                if(a< b){
                    infor[0]= infor[i];
                    infor[i]= infor[j];
                    infor[j]= infor[0];
                }
           }
    }
    public static void main(String[] args) {
        int getChoice;
        do{
            getChoice= funRun.getUserChoice();
            switch(getChoice){
                case 1: accName();
                        break;
                case 2: accScore();
                        break;
                case 3: printOut();
                        break;
                case 4: calType();
                        break;
                case 5: sortList();
                        break;
            }
        }while(getChoice> 0&& getChoice< 6);
    }
}
