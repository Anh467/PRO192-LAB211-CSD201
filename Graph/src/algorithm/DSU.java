/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.DSCanh;

/**
 *
 * @author 84384
 */
public class DSU {
    // con-> cha
    int[] parent;
    ArrayList<DSCanh> DSCanhList= new ArrayList<>();
    int V, E;

    public DSU(int V, int E, ArrayList<DSCanh> DSCanhList) {
        this.V = V;
        this.E = E;
        this.DSCanhList.addAll(DSCanhList);
        parent= new int[E+1];
    }
    public void make_set(){
        for(int i=0; i< V; i++)
            parent[i]=i;
    }
    public int find_set(int element) {
        if (element == parent[element])
            return element;
        return find_set(parent[element]);
    }
    public boolean union_sets(int a, int b) {
        a = find_set(a);
        b = find_set(b);
        if (a != b){
            parent[b]= a;
            return true;
        }
        return false;
    }
    public ArrayList<DSCanh> getSpanningTree(){
        make_set();
        Collections.sort(DSCanhList);
        int i=0;
        int j=0;
        ArrayList<DSCanh> NewDSCanhList= new ArrayList<>();
        while(NewDSCanhList.size()<V&&j<DSCanhList.size()){
            if(union_sets((int)DSCanhList.get(j).getA(), (int)DSCanhList.get(j).getB()))
                NewDSCanhList.add(DSCanhList.get(j));
            j++;
        }
        return NewDSCanhList;
    }
}
