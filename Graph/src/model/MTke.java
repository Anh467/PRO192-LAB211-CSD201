/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import model.DSCanh;
public class MTke{
    Integer V;
    Integer [][] entry;
    public MTke(int V) {
        this.V = V;
        entry= new Integer[V][V];
        for(int i= 0; i< V; i++)
            for(int j= 0; j< V; j++)
                if(i==j)
                    entry[i][j]= 0;
                else
                entry[i][j]= Integer.MAX_VALUE;
    }
    public Integer [][] changeToMTke(int V, ArrayList<DSCanh> DSCanhList){
        for(int i=0; i< DSCanhList.size(); i++){
            entry[(Integer)DSCanhList.get(i).getA()][(Integer)DSCanhList.get(i).getB()]=(Integer) DSCanhList.get(i).getLength();
            entry[(Integer)DSCanhList.get(i).getB()][(Integer)DSCanhList.get(i).getA()]=(Integer) DSCanhList.get(i).getLength();
        }
        return entry;
    }
    public void view() {
        for(int i= 0; i< V; i++){
            for(int j= 0; j< V; j++)
                if (entry[i][j]== Integer.MAX_VALUE)
                    System.out.print((-1)+" ");
                else
                    System.out.print(entry[i][j]+" ");
            System.out.println("");
        }
    }
}
